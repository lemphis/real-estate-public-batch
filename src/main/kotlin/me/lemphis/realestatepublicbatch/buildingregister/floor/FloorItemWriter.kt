package me.lemphis.realestatepublicbatch.buildingregister.floor

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FloorItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.floor (관리건축물대장PK,
                           대지위치,
                           도로명대지위치,
                           건물명,
                           시군구코드,
                           법정동코드,
                           대지구분코드,
                           번,
                           지,
                           특수지명,
                           블록,
                           로트,
                           새주소도로코드,
                           새주소법정동코드,
                           새주소지상지하코드,
                           새주소본번,
                           새주소부번,
                           동명,
                           층구분코드,
                           층구분코드명,
                           층번호,
                           층번호명,
                           구조코드,
                           구조코드명,
                           기타구조,
                           주용도코드,
                           주용도코드명,
                           기타용도,
                           면적,
                           주부속구분코드,
                           주부속구분코드명,
                           면적제외여부,
                           생성일자)
		VALUES (:관리건축물대장PK,
				:대지위치,
				:도로명대지위치,
				:건물명,
				:시군구코드,
				:법정동코드,
				:대지구분코드,
				:번,
				:지,
				:특수지명,
				:블록,
				:로트,
				:새주소도로코드,
				:새주소법정동코드,
				:새주소지상지하코드,
				:새주소본번,
				:새주소부번,
				:동명,
				:층구분코드,
				:층구분코드명,
				:층번호,
				:층번호명,
				:구조코드,
				:구조코드명,
				:기타구조,
				:주용도코드,
				:주용도코드명,
				:기타용도,
				:면적,
				:주부속구분코드,
				:주부속구분코드명,
				:면적제외여부,
				:생성일자)
		ON DUPLICATE KEY UPDATE 대지위치      = VALUES(대지위치),
								도로명대지위치   = VALUES(도로명대지위치),
								건물명       = VALUES(건물명),
								시군구코드     = VALUES(시군구코드),
								법정동코드     = VALUES(법정동코드),
								대지구분코드    = VALUES(대지구분코드),
								번         = VALUES(번),
								지         = VALUES(지),
								특수지명      = VALUES(특수지명),
								블록        = VALUES(블록),
								로트        = VALUES(로트),
								새주소도로코드   = VALUES(새주소도로코드),
								새주소법정동코드  = VALUES(새주소법정동코드),
								새주소지상지하코드 = VALUES(새주소지상지하코드),
								새주소본번     = VALUES(새주소본번),
								새주소부번     = VALUES(새주소부번),
								동명        = VALUES(동명),
								층구분코드     = VALUES(층구분코드),
								층구분코드명    = VALUES(층구분코드명),
								층번호       = VALUES(층번호),
								층번호명      = VALUES(층번호명),
								구조코드      = VALUES(구조코드),
								구조코드명     = VALUES(구조코드명),
								기타구조      = VALUES(기타구조),
								주용도코드     = VALUES(주용도코드),
								주용도코드명    = VALUES(주용도코드명),
								기타용도      = VALUES(기타용도),
								면적        = VALUES(면적),
								주부속구분코드   = VALUES(주부속구분코드),
								주부속구분코드명  = VALUES(주부속구분코드명),
								면적제외여부    = VALUES(면적제외여부),
								생성일자      = VALUES(생성일자)
	""".trimIndent()

	@Bean
	fun floorJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Floor>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
