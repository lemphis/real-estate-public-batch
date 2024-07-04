package me.lemphis.realestatepublicbatch.job.gis.legalpolygon

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class LegalPolygonItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.legal_polygon(법정동코드,
										  polygon,
										  원천도형ID,
										  지역명,
										  데이터기준일자,
										  원천시도시군구코드)
		VALUES (:법정동코드,
				ST_GEOMFROMTEXT(:polygon),
				:원천도형ID,
				:지역명,
				:데이터기준일자,
				:원천시도시군구코드)
		ON DUPLICATE KEY UPDATE polygon   = VALUES(polygon),
								원천도형ID    = VALUES(원천도형ID),
								지역명       = VALUES(지역명),
								데이터기준일자   = VALUES(데이터기준일자),
								원천시도시군구코드 = VALUES(원천시도시군구코드)
	""".trimIndent()

	@Bean
	fun legalPolygonJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<LegalPolygon>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
