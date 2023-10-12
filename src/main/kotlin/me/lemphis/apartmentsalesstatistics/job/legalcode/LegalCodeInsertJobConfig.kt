package me.lemphis.apartmentsalesstatistics.job.legalcode

import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.function.FunctionItemProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.transaction.PlatformTransactionManager
import java.time.LocalDate
import javax.sql.DataSource

@Configuration
class LegalCodeInsertJobConfig(
	private val jobRepository: JobRepository,
	private val transactionManager: PlatformTransactionManager,
	private val dataSource: DataSource,
) {

	private val jobName = "legalCodeInsertJob"
	private val stepName = "legalCodeInsertStep"
	private val fileReaderName = "legalCodeFileReader"
	private val filePath = "data/codes.csv"
	private val chunkSize = 1_000
	private val columns = listOf(
		"code",
		"sido",
		"sigungu",
		"eupmyeondong",
		"ri",
		"rank",
		"createdAt",
		"deletedAt",
		"beforeLegalCode",
	)
	private val insertSql = """
		INSERT INTO legal_code(code, sido, sigungu, eupmyeondong, ri, created_at)
		VALUES (:code, :sido, :sigungu, :eupmyeondong, :ri, :createdAt);
	""".trimIndent()

	@Bean
	fun legalCodeInsertJob() = JobBuilder(jobName, jobRepository)
		.start(legalCodeInsertStep())
		.build()

	private fun legalCodeInsertStep() = StepBuilder(stepName, jobRepository)
		.chunk<LegalCodeFileSpec, LegalCode>(chunkSize, transactionManager)
		.reader(legalCodeFileReader())
		.processor(legalCodeProcessor())
		.writer(legalCodeWriter())
		.build()

	private fun legalCodeFileReader() = FlatFileItemReaderBuilder<LegalCodeFileSpec>()
		.name(fileReaderName)
		.encoding("EUC-KR")
		.linesToSkip(1)
		.resource(ClassPathResource(filePath))
		.delimited().delimiter(",").names(*columns.toTypedArray())
		.fieldSetMapper(legalCodeFieldSetMapper())
		.build()

	private fun legalCodeFieldSetMapper() = FieldSetMapper<LegalCodeFileSpec> { fieldSet ->
		val code = fieldSet.readString("code")
		val sido = fieldSet.readString("sido")
		val sigungu = fieldSet.readString("sigungu")
		val eupmyeondong = fieldSet.readString("eupmyeondong")
		val ri = fieldSet.readString("ri")
		val rank = fieldSet.readString("rank")
		val createdAt = fieldSet.readString("createdAt")
		val deletedAt = fieldSet.readString("deletedAt")
		val beforeLegalCode = fieldSet.readString("beforeLegalCode")
		val values = columns.map { fieldSet.readString(it) }
		LegalCodeFileSpec(
			code = code,
			sido = sido,
			sigungu = sigungu.ifBlank { null },
			eupmyeondong = eupmyeondong.ifBlank { null },
			ri = ri.ifBlank { null },
			rank = if (rank.isNotBlank()) rank.toInt() else null,
			createdAt = if (createdAt.isNotBlank()) LocalDate.parse(createdAt) else null,
			deletedAt = if (deletedAt.isNotBlank()) LocalDate.parse(deletedAt) else null,
			beforeLegalCode = beforeLegalCode.ifBlank { null },
		)
	}

	private fun legalCodeProcessor() = FunctionItemProcessor<LegalCodeFileSpec, LegalCode> {
		if (it.deletedAt != null) {
			return@FunctionItemProcessor null
		}
		it.toLegalCode()
	}

	@Bean
	fun legalCodeWriter() = JdbcBatchItemWriterBuilder<LegalCode>()
		.dataSource(dataSource)
		.sql(insertSql)
		.beanMapped()
		.build()

}
