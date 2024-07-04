package me.lemphis.realestatepublicbatch.job.legal

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
class LegalLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val legalApiItemReader: ItemReader<LegalApiContent>,
	private val legalItemProcessor: ItemProcessor<LegalApiContent, Legal>,
	private val legalJdbcBatchItemWriter: ItemWriter<Legal>,
) {

	private companion object {
		const val JOB_NAME = "legalLoadJob"
		const val STEP_NAME = "legalLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun legalInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(legalInsertStep())
		.build()

	private fun legalInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<LegalApiContent, Legal>(CHUNK_SIZE, transactionManager)
		.reader(legalApiItemReader)
		.processor(legalItemProcessor)
		.writer(legalJdbcBatchItemWriter)
		.build()

}

