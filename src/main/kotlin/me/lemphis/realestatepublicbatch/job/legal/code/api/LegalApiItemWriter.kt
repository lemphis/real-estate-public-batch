package me.lemphis.realestatepublicbatch.job.legal.code.api

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LegalApiItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.legal_api (법정동코드,
                           시도명,
                           시군구명,
                           읍면동명,
                           리명,
                           순위,
                           삭제일자,
                           생성일자,
                           과거법정동코드)
		VALUES (:법정동코드,
				:시도명,
				:시군구명,
				:읍면동명,
				:리명,
				:순위,
				:삭제일자,
				:생성일자,
				:과거법정동코드)
		ON DUPLICATE KEY UPDATE 시도명     = VALUES(시도명),
								시군구명    = VALUES(시군구명),
								읍면동명    = VALUES(읍면동명),
								리명      = VALUES(리명),
								순위      = VALUES(순위),
								삭제일자    = VALUES(삭제일자),
								생성일자    = VALUES(생성일자),
								과거법정동코드 = VALUES(과거법정동코드)
	""".trimIndent()

	@Bean
	fun legalApiJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Legal>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
