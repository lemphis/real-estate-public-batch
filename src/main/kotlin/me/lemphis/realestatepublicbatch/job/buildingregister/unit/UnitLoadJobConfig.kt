package me.lemphis.realestatepublicbatch.job.buildingregister.unit

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
class UnitLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val unitFlatFileItemReader: ItemReader<UnitFileSpec>,
    private val unitItemProcessor: ItemProcessor<UnitFileSpec, Unit>,
    private val unitJdbcBatchItemWriter: ItemWriter<Unit>,
) {

    private companion object {
        const val JOB_NAME = "unitLoadJob"
        const val STEP_NAME = "unitLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun unitInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(unitInsertStep())
        .build()

    private fun unitInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<UnitFileSpec, Unit>(CHUNK_SIZE, transactionManager)
        .reader(unitFlatFileItemReader)
        .processor(unitItemProcessor)
        .writer(unitJdbcBatchItemWriter)
        .build()

}

