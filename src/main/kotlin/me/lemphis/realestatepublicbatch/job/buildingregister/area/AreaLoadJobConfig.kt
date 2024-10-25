package me.lemphis.realestatepublicbatch.job.buildingregister.area

import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class AreaLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val areaFlatFileItemReader: ItemReader<AreaFileSpec>,
    private val areaItemProcessor: ItemProcessor<AreaFileSpec, Area>,
    private val areaJdbcBatchItemWriter: ItemWriter<Area>,
) {

    private companion object {
        const val JOB_NAME = "areaLoadJob"
        const val STEP_NAME = "areaLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun areaInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(areaInsertStep())
        .build()

    private fun areaInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<AreaFileSpec, Area>(CHUNK_SIZE, transactionManager)
        .reader(areaFlatFileItemReader)
        .processor(areaItemProcessor)
        .writer(areaJdbcBatchItemWriter)
        .build()

}

