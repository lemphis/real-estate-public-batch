package me.lemphis.realestatepublicbatch.gis.landpolygon

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class LandPolygonItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.land_polygon(고유번호,
										 polygon,
										 법정동코드,
										 법정동명,
										 대장구분코드,
										 대장구분명,
										 지번,
										 지번지목부호,
										 기준연도,
										 기준월,
										 개별공시지가,
										 표준지여부,
										 지목코드,
										 지목,
										 토지면적,
										 데이터기준일자,
										 원천시도시군구코드,
										 과년도1공시지가,
										 과년도2공시지가,
										 과년도3공시지가,
										 과년도4공시지가)
		VALUES (:고유번호,
				ST_GEOMFROMTEXT(:polygon),
				:법정동코드,
				:법정동명,
				:대장구분코드,
				:대장구분명,
				:지번,
				:지번지목부호,
				:기준연도,
				:기준월,
				:개별공시지가,
				:표준지여부,
				:지목코드,
				:지목,
				:토지면적,
				:데이터기준일자,
				:원천시도시군구코드,
				:과년도1공시지가,
				:과년도2공시지가,
				:과년도3공시지가,
				:과년도4공시지가)
		ON DUPLICATE KEY UPDATE 고유번호      = VALUES(고유번호),
								polygon    = VALUES(polygon),
								법정동코드     = VALUES(법정동코드),
								법정동명      = VALUES(법정동명),
								대장구분코드    = VALUES(대장구분코드),
								대장구분명     = VALUES(대장구분명),
								지번        = VALUES(지번),
								지번지목부호    = VALUES(지번지목부호),
								기준연도      = VALUES(기준연도),
								기준월       = VALUES(기준월),
								개별공시지가    = VALUES(개별공시지가),
								표준지여부     = VALUES(표준지여부),
								지목코드      = VALUES(지목코드),
								지목        = VALUES(지목),
								토지면적      = VALUES(토지면적),
								데이터기준일자   = VALUES(데이터기준일자),
								원천시도시군구코드 = VALUES(원천시도시군구코드),
								과년도1공시지가  = VALUES(과년도1공시지가),
								과년도2공시지가  = VALUES(과년도2공시지가),
								과년도3공시지가  = VALUES(과년도3공시지가),
								과년도4공시지가  = VALUES(과년도4공시지가)
	""".trimIndent()

	@Bean
	fun landPolygonJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<LandPolygon>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
