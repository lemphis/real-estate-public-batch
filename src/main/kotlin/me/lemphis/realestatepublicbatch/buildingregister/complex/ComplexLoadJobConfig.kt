package me.lemphis.realestatepublicbatch.buildingregister.complex

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
class ComplexLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val complexFlatFileItemReader: ItemReader<ComplexFileSpec>,
	private val complexItemProcessor: ItemProcessor<ComplexFileSpec, Complex>,
	private val complexJdbcBatchItemWriter: ItemWriter<Complex>,
) {

	private companion object {
		const val JOB_NAME = "complexLoadJob"
		const val STEP_NAME = "complexLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun complexInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(complexInsertStep())
		.build()

	private fun complexInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<ComplexFileSpec, Complex>(CHUNK_SIZE, transactionManager)
		.reader(complexFlatFileItemReader)
		.processor(complexItemProcessor)
		.writer(complexJdbcBatchItemWriter)
		.build()

}

