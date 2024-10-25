package me.lemphis.realestatepublicbatch.job.legal.code.file

import org.springframework.batch.item.database.ItemSqlParameterSourceProvider
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class LegalFileItemWriter(
    private val dataSource: DataSource,
) {
    val insertQuery = """
		INSERT INTO service.legal_file (code,
										name,
										is_active)
		VALUES (:code,
				:name,
				:isActive)
		ON DUPLICATE KEY UPDATE name      = VALUES(name),
								is_active = VALUES(is_active)
	""".trimIndent()

    @Bean
    fun legalFileJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Legal>()
        .dataSource(dataSource)
        .sql(insertQuery)
        .columnMapped()
        .itemSqlParameterSourceProvider(itemSqlParameterSourceProvider())
        .build()

    private fun itemSqlParameterSourceProvider() = ItemSqlParameterSourceProvider<Legal> { item ->
        val paramMap = mapOf(
            "code" to item.code,
            "name" to item.name,
            "isActive" to item.isActive,
        )
        MapSqlParameterSource(paramMap)
    }

}
