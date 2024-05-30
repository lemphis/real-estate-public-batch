package me.lemphis.realestatepublicbatch.buildingregister.floor

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
class FloorLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val floorFlatFileItemReader: ItemReader<FloorFileSpec>,
	private val floorItemProcessor: ItemProcessor<FloorFileSpec, Floor>,
	private val floorJdbcBatchItemWriter: ItemWriter<Floor>,
) {

	private companion object {
		const val JOB_NAME = "floorLoadJob"
		const val STEP_NAME = "floorLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun floorInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(floorInsertStep())
		.build()

	private fun floorInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<FloorFileSpec, Floor>(CHUNK_SIZE, transactionManager)
		.reader(floorFlatFileItemReader)
		.processor(floorItemProcessor)
		.writer(floorJdbcBatchItemWriter)
		.build()

}

