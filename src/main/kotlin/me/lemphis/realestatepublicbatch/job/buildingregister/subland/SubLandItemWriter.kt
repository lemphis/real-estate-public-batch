package me.lemphis.realestatepublicbatch.job.buildingregister.subland

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class SubLandItemWriter(
    private val dataSource: DataSource,
) {
    val insertQuery = """
		INSERT INTO service.sub_land (관리건축물대장PK,
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
                              부속대장구분코드,
                              부속대장구분코드명,
                              부속시군구코드,
                              부속법정동코드,
                              부속대지구분코드,
                              부속번,
                              부속지,
                              부속특수지명,
                              부속블록,
                              부속로트,
                              부속기타지번명,
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
				:부속대장구분코드,
				:부속대장구분코드명,
				:부속시군구코드,
				:부속법정동코드,
				:부속대지구분코드,
				:부속번,
				:부속지,
				:부속특수지명,
				:부속블록,
				:부속로트,
				:부속기타지번명,
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
								부속대장구분코드  = VALUES(부속대장구분코드),
								부속대장구분코드명 = VALUES(부속대장구분코드명),
								부속시군구코드   = VALUES(부속시군구코드),
								부속법정동코드   = VALUES(부속법정동코드),
								부속대지구분코드  = VALUES(부속대지구분코드),
								부속번       = VALUES(부속번),
								부속지       = VALUES(부속지),
								부속특수지명    = VALUES(부속특수지명),
								부속블록      = VALUES(부속블록),
								부속로트      = VALUES(부속로트),
								부속기타지번명   = VALUES(부속기타지번명),
								생성일자      = VALUES(생성일자)
	""".trimIndent()

    @Bean
    fun subLandJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<SubLand>()
        .dataSource(dataSource)
        .sql(insertQuery)
        .beanMapped()
        .build()

}
