package me.lemphis.realestatepublicbatch.buildingregister.unit

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class UnitItemWriter(
	private val dataSource: DataSource,
) {
	val insertQuery = """
		INSERT INTO service.unit (관리건축물대장PK,
                          대장구분코드,
                          대장구분코드명,
                          대장종류코드,
                          대장종류코드명,
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
                          호명,
                          층구분코드,
                          층구분코드명,
                          층번호,
                          생성일자)
		VALUES (:관리건축물대장PK,
				:대장구분코드,
				:대장구분코드명,
				:대장종류코드,
				:대장종류코드명,
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
				:호명,
				:층구분코드,
				:층구분코드명,
				:층번호,
				:생성일자)
		ON DUPLICATE KEY UPDATE 대장구분코드    = VALUES(대장구분코드),
								대장구분코드명   = VALUES(대장구분코드명),
								대장종류코드    = VALUES(대장종류코드),
								대장종류코드명   = VALUES(대장종류코드명),
								대지위치      = VALUES(대지위치),
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
								호명        = VALUES(호명),
								층구분코드     = VALUES(층구분코드),
								층구분코드명    = VALUES(층구분코드명),
								층번호       = VALUES(층번호),
								생성일자      = VALUES(생성일자)
	""".trimIndent()

	@Bean
	fun unitJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Unit>()
		.dataSource(dataSource)
		.sql(insertQuery)
		.beanMapped()
		.build()

}
