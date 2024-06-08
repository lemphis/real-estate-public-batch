package me.lemphis.realestatepublicbatch.gis.buildingpolygon

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class BuildingPolygonItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.building_polygon(polygon,
											 원천도형ID,
											 GIS건물통합식별번호,
											 고유번호,
											 법정동코드,
											 법정동명,
											 지번,
											 특수지코드,
											 특수지구분명,
											 건축물용도코드,
											 건축물용도명,
											 건축물구조코드,
											 건축물구조명,
											 건축물면적,
											 사용승인일자,
											 연면적,
											 대지면적,
											 높이,
											 건폐율,
											 용적율,
											 건축물ID,
											 위반건축물여부,
											 참조체계연계키,
											 데이터기준일자,
											 원천시도시군구코드,
											 건물명,
											 건물동명,
											 지상층수,
											 지하층수,
											 데이터생성변경일자)
		VALUES (ST_GEOMFROMTEXT(:polygon),
				:원천도형ID,
				:GIS건물통합식별번호,
				:고유번호,
				:법정동코드,
				:법정동명,
				:지번,
				:특수지코드,
				:특수지구분명,
				:건축물용도코드,
				:건축물용도명,
				:건축물구조코드,
				:건축물구조명,
				:건축물면적,
				:사용승인일자,
				:연면적,
				:대지면적,
				:높이,
				:건폐율,
				:용적율,
				:건축물ID,
				:위반건축물여부,
				:참조체계연계키,
				:데이터기준일자,
				:원천시도시군구코드,
				:건물명,
				:건물동명,
				:지상층수,
				:지하층수,
				:데이터생성변경일자)
		ON DUPLICATE KEY UPDATE polygon     = VALUES(polygon),
								원천도형ID      = VALUES(원천도형ID),
								GIS건물통합식별번호 = VALUES(GIS건물통합식별번호),
								고유번호        = VALUES(고유번호),
								법정동코드       = VALUES(법정동코드),
								법정동명        = VALUES(법정동명),
								지번          = VALUES(지번),
								특수지코드       = VALUES(특수지코드),
								특수지구분명      = VALUES(특수지구분명),
								건축물용도코드     = VALUES(건축물용도코드),
								건축물용도명      = VALUES(건축물용도명),
								건축물구조코드     = VALUES(건축물구조코드),
								건축물구조명      = VALUES(건축물구조명),
								건축물면적       = VALUES(건축물면적),
								사용승인일자      = VALUES(사용승인일자),
								연면적         = VALUES(연면적),
								대지면적        = VALUES(대지면적),
								높이          = VALUES(높이),
								건폐율         = VALUES(건폐율),
								용적율         = VALUES(용적율),
								건축물ID       = VALUES(건축물ID),
								위반건축물여부     = VALUES(위반건축물여부),
								참조체계연계키     = VALUES(참조체계연계키),
								데이터기준일자     = VALUES(데이터기준일자),
								원천시도시군구코드   = VALUES(원천시도시군구코드),
								건물명         = VALUES(건물명),
								건물동명        = VALUES(건물동명),
								지상층수        = VALUES(지상층수),
								지하층수        = VALUES(지하층수),
								데이터생성변경일자   = VALUES(데이터생성변경일자)
	""".trimIndent()

	@Bean
	fun buildingPolygonJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<BuildingPolygon>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
