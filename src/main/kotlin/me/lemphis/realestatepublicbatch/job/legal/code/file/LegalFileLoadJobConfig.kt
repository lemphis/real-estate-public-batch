package me.lemphis.realestatepublicbatch.job.legal.code.file

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
class LegalFileLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val legalFlatFileItemReader: ItemReader<LegalFileSpec>,
    private val legalFileItemProcessor: ItemProcessor<LegalFileSpec, Legal>,
    private val legalFileJdbcBatchItemWriter: ItemWriter<Legal>,
) {

    private companion object {
        const val JOB_NAME = "legalFileLoadJob"
        const val STEP_NAME = "legalFileLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun legalFileInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(legalInsertStep())
        .build()

    private fun legalInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<LegalFileSpec, Legal>(CHUNK_SIZE, transactionManager)
        .reader(legalFlatFileItemReader)
        .processor(legalFileItemProcessor)
        .writer(legalFileJdbcBatchItemWriter)
        .build()

}

