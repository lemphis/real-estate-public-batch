package me.lemphis.realestatepublicbatch.job.land

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
class LandLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val landMultiFileItemReader: ItemReader<LandFileSpec>,
    private val landItemProcessor: ItemProcessor<LandFileSpec, Land>,
    private val landJdbcBatchItemWriter: ItemWriter<Land>,
) {

    private companion object {
        const val JOB_NAME = "landLoadJob"
        const val STEP_NAME = "landLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun landInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(landInsertStep())
        .build()

    private fun landInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<LandFileSpec, Land>(CHUNK_SIZE, transactionManager)
        .reader(landMultiFileItemReader)
        .processor(landItemProcessor)
        .writer(landJdbcBatchItemWriter)
        .build()

}

