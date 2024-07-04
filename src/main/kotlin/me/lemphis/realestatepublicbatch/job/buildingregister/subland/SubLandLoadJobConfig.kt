package me.lemphis.realestatepublicbatch.job.buildingregister.subland

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
class SubLandLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val subLandFlatFileItemReader: ItemReader<SubLandFileSpec>,
	private val subLandItemProcessor: ItemProcessor<SubLandFileSpec, SubLand>,
	private val subLandJdbcBatchItemWriter: ItemWriter<SubLand>,
) {

	private companion object {
		const val JOB_NAME = "subLandLoadJob"
		const val STEP_NAME = "subLandLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun subLandInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(subLandInsertStep())
		.build()

	private fun subLandInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<SubLandFileSpec, SubLand>(CHUNK_SIZE, transactionManager)
		.reader(subLandFlatFileItemReader)
		.processor(subLandItemProcessor)
		.writer(subLandJdbcBatchItemWriter)
		.build()

}

