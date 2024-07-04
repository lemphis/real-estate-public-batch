package me.lemphis.realestatepublicbatch.job.buildingregister.summary

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
class SummaryLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val summaryFlatFileItemReader: ItemReader<SummaryFileSpec>,
	private val summaryItemProcessor: ItemProcessor<SummaryFileSpec, Summary>,
	private val summaryJdbcBatchItemWriter: ItemWriter<Summary>,
) {

	private companion object {
		const val JOB_NAME = "summaryLoadJob"
		const val STEP_NAME = "summaryLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun summaryInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(summaryInsertStep())
		.build()

	private fun summaryInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<SummaryFileSpec, Summary>(CHUNK_SIZE, transactionManager)
		.reader(summaryFlatFileItemReader)
		.processor(summaryItemProcessor)
		.writer(summaryJdbcBatchItemWriter)
		.build()

}

