package me.lemphis.realestatepublicbatch.job.legal.code.api

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
class LegalApiLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val legalApiItemReader: ItemReader<LegalApiContent>,
    private val legalApiItemProcessor: ItemProcessor<LegalApiContent, Legal>,
    private val legalApiJdbcBatchItemWriter: ItemWriter<Legal>,
) {

    private companion object {
        const val JOB_NAME = "legalApiLoadJob"
        const val STEP_NAME = "legalApiLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun legalApiInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(legalInsertStep())
        .build()

    private fun legalInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<LegalApiContent, Legal>(CHUNK_SIZE, transactionManager)
        .reader(legalApiItemReader)
        .processor(legalApiItemProcessor)
        .writer(legalApiJdbcBatchItemWriter)
        .build()

}

