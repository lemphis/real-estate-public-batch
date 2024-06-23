package me.lemphis.realestatepublicbatch.gis.legalpolygon

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
class LegalPolygonLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val legalPolygonMultiFileItemReader: ItemReader<LegalPolygonFileSpec>,
	private val legalPolygonItemProcessor: ItemProcessor<LegalPolygonFileSpec, LegalPolygon>,
	private val legalPolygonJdbcBatchItemWriter: ItemWriter<LegalPolygon>,
) {

	private companion object {
		const val JOB_NAME = "legalPolygonLoadJob"
		const val STEP_NAME = "legalPolygonLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun legalPolygonInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.start(legalPolygonInsertStep())
		.build()

	private fun legalPolygonInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<LegalPolygonFileSpec, LegalPolygon>(CHUNK_SIZE, transactionManager)
		.reader(legalPolygonMultiFileItemReader)
		.processor(legalPolygonItemProcessor)
		.writer(legalPolygonJdbcBatchItemWriter)
		.build()

}

