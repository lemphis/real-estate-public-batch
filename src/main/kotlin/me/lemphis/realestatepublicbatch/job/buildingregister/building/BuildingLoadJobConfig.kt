package me.lemphis.realestatepublicbatch.job.buildingregister.building

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
class BuildingLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val buildingFlatFileItemReader: ItemReader<BuildingFileSpec>,
    private val buildingItemProcessor: ItemProcessor<BuildingFileSpec, Building>,
    private val buildingJdbcBatchItemWriter: ItemWriter<Building>,
) {

    private companion object {
        const val JOB_NAME = "buildingLoadJob"
        const val STEP_NAME = "buildingLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun buildingInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(buildingInsertStep())
        .build()

    private fun buildingInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<BuildingFileSpec, Building>(CHUNK_SIZE, transactionManager)
        .reader(buildingFlatFileItemReader)
        .processor(buildingItemProcessor)
        .writer(buildingJdbcBatchItemWriter)
        .build()

}

