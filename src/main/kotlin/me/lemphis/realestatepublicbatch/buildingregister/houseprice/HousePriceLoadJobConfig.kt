package me.lemphis.realestatepublicbatch.buildingregister.houseprice

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
class HousePriceLoadJobConfig(
	private val transactionManager: PlatformTransactionManager,
	private val jobRepository: JobRepository,
	private val housePriceFlatFileItemReader: ItemReader<HousePriceFileSpec>,
	private val housePriceItemProcessor: ItemProcessor<HousePriceFileSpec, HousePrice>,
	private val housePriceJdbcBatchItemWriter: ItemWriter<HousePrice>,
) {

	private companion object {
		const val JOB_NAME = "housePriceLoadJob"
		const val STEP_NAME = "housePriceLoadStep"
		const val CHUNK_SIZE = 2_000
	}

	@Bean
	fun housePriceInsertJob() = JobBuilder(JOB_NAME, jobRepository)
		.incrementer(RunIdIncrementer())
		.start(housePriceInsertStep())
		.build()

	private fun housePriceInsertStep() = StepBuilder(STEP_NAME, jobRepository)
		.chunk<HousePriceFileSpec, HousePrice>(CHUNK_SIZE, transactionManager)
		.reader(housePriceFlatFileItemReader)
		.processor(housePriceItemProcessor)
		.writer(housePriceJdbcBatchItemWriter)
		.build()

}

