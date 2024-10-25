package me.lemphis.realestatepublicbatch.job.buildingregister.wastewatertreatmentplant

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
class WastewaterTreatmentPlantLoadJobConfig(
    private val transactionManager: PlatformTransactionManager,
    private val jobRepository: JobRepository,
    private val wastewaterTreatmentPlantFlatFileItemReader: ItemReader<WastewaterTreatmentPlantFileSpec>,
    private val wastewaterTreatmentPlantItemProcessor: ItemProcessor<WastewaterTreatmentPlantFileSpec, WastewaterTreatmentPlant>,
    private val wastewaterTreatmentPlantJdbcBatchItemWriter: ItemWriter<WastewaterTreatmentPlant>,
) {

    private companion object {
        const val JOB_NAME = "wastewaterTreatmentPlantLoadJob"
        const val STEP_NAME = "wastewaterTreatmentPlantLoadStep"
        const val CHUNK_SIZE = 2_000
    }

    @Bean
    fun wastewaterTreatmentPlantInsertJob() = JobBuilder(JOB_NAME, jobRepository)
        .incrementer(RunIdIncrementer())
        .start(wastewaterTreatmentPlantInsertStep())
        .build()

    private fun wastewaterTreatmentPlantInsertStep() = StepBuilder(STEP_NAME, jobRepository)
        .chunk<WastewaterTreatmentPlantFileSpec, WastewaterTreatmentPlant>(CHUNK_SIZE, transactionManager)
        .reader(wastewaterTreatmentPlantFlatFileItemReader)
        .processor(wastewaterTreatmentPlantItemProcessor)
        .writer(wastewaterTreatmentPlantJdbcBatchItemWriter)
        .build()

}

