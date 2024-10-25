package me.lemphis.realestatepublicbatch.job.gis.buildingpolygon

import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class BuildingPolygonLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val buildingPolygonMultiFileItemReader: ItemReader<BuildingPolygonFileSpec>,
    private val buildingPolygonItemProcessor: ItemProcessor<BuildingPolygonFileSpec, BuildingPolygon>,
    private val buildingPolygonJdbcBatchItemWriter: ItemWriter<BuildingPolygon>,
) {

    private companion object {
        const val JOB_NAME = "buildingPolygonLoadJob"
        const val STEP_NAME = "buildingPolygonLoadStep"
        const val CHUNK_SIZE = 1_000
    }

    @Bean
    fun buildingPolygonInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .start(buildingPolygonInsertStep())
        .build()

    private fun buildingPolygonInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<BuildingPolygonFileSpec, BuildingPolygon>(CHUNK_SIZE, transactionManager)
        .reader(buildingPolygonMultiFileItemReader)
        .processor(buildingPolygonItemProcessor)
        .writer(buildingPolygonJdbcBatchItemWriter)
        .build()

}

