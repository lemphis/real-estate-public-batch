package me.lemphis.realestatepublicbatch.job.buildingregister.owner

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
class OwnerLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val ownerFlatFileItemReader: ItemReader<OwnerFileSpec>,
	private val ownerItemProcessor: ItemProcessor<OwnerFileSpec, Owner>,
	private val ownerJdbcBatchItemWriter: ItemWriter<Owner>,
) {

	private companion object {
		const val JOB_NAME = "ownerLoadJob"
		const val STEP_NAME = "ownerLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun ownerInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(ownerInsertStep())
		.build()

	private fun ownerInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<OwnerFileSpec, Owner>(CHUNK_SIZE, transactionManager)
		.reader(ownerFlatFileItemReader)
		.processor(ownerItemProcessor)
		.writer(ownerJdbcBatchItemWriter)
		.build()

}

