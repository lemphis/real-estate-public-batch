package me.lemphis.realestatepublicbatch.job.gis.landpolygon

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
class LandPolygonLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val landPolygonMultiFileItemReader: ItemReader<LandPolygonFileSpec>,
    private val landPolygonItemProcessor: ItemProcessor<LandPolygonFileSpec, LandPolygon>,
    private val landPolygonJdbcBatchItemWriter: ItemWriter<LandPolygon>,
) {

    private companion object {
        const val JOB_NAME = "landPolygonLoadJob"
        const val STEP_NAME = "landPolygonLoadStep"
        const val CHUNK_SIZE = 1_000
    }

    @Bean
    fun landPolygonInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .start(landPolygonInsertStep())
        .incrementer(RunIdIncrementer())
        .build()

    private fun landPolygonInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<LandPolygonFileSpec, LandPolygon>(CHUNK_SIZE, transactionManager)
        .reader(landPolygonMultiFileItemReader)
        .processor(landPolygonItemProcessor)
        .writer(landPolygonJdbcBatchItemWriter)
        .build()

}

