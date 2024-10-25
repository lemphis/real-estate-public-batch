package me.lemphis.realestatepublicbatch.job.buildingregister.owner

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class OwnerItemWriter(
    private val dataSource: DataSource,
) {
    val insertQuery = """
		INSERT INTO service.owner (관리건축물대장PK,
								   시군구코드,
								   시군구명,
								   법정동코드,
								   법정동명,
								   대지구분코드,
								   대지구분명,
								   번,
								   지,
								   특수지명,
								   블록,
								   로트,
								   새주소대지위치,
								   새주소도로코드,
								   새주소법정동코드,
								   새주소지상지하코드,
								   새주소지상지하명,
								   새주소본번,
								   새주소부번,
								   대장구분코드,
								   대장구분명,
								   대장종류코드,
								   대장종류명,
								   건물명,
								   동명칭,
								   호명칭,
								   면적,
								   소유구분코드,
								   소유구분명,
								   변동원인일)
		VALUES (:관리건축물대장PK,
				:시군구코드,
				:시군구명,
				:법정동코드,
				:법정동명,
				:대지구분코드,
				:대지구분명,
				:번,
				:지,
				:특수지명,
				:블록,
				:로트,
				:새주소대지위치,
				:새주소도로코드,
				:새주소법정동코드,
				:새주소지상지하코드,
				:새주소지상지하명,
				:새주소본번,
				:새주소부번,
				:대장구분코드,
				:대장구분명,
				:대장종류코드,
				:대장종류명,
				:건물명,
				:동명칭,
				:호명칭,
				:면적,
				:소유구분코드,
				:소유구분명,
				:변동원인일)
		ON DUPLICATE KEY UPDATE 시군구코드     = VALUES(시군구코드),
								시군구명      = VALUES(시군구명),
								법정동코드     = VALUES(법정동코드),
								법정동명      = VALUES(법정동명),
								대지구분코드    = VALUES(대지구분코드),
								대지구분명     = VALUES(대지구분명),
								번         = VALUES(번),
								지         = VALUES(지),
								특수지명      = VALUES(특수지명),
								블록        = VALUES(블록),
								로트        = VALUES(로트),
								새주소대지위치   = VALUES(새주소대지위치),
								새주소도로코드   = VALUES(새주소도로코드),
								새주소법정동코드  = VALUES(새주소법정동코드),
								새주소지상지하코드 = VALUES(새주소지상지하코드),
								새주소지상지하명  = VALUES(새주소지상지하명),
								새주소본번     = VALUES(새주소본번),
								새주소부번     = VALUES(새주소부번),
								대장구분코드    = VALUES(대장구분코드),
								대장구분명     = VALUES(대장구분명),
								대장종류코드    = VALUES(대장종류코드),
								대장종류명     = VALUES(대장종류명),
								건물명       = VALUES(건물명),
								동명칭       = VALUES(동명칭),
								호명칭       = VALUES(호명칭),
								면적        = VALUES(면적),
								소유구분코드    = VALUES(소유구분코드),
								소유구분명     = VALUES(소유구분명),
								변동원인일     = VALUES(변동원인일)
	""".trimIndent()

    @Bean
    fun ownerJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Owner>()
        .dataSource(dataSource)
        .sql(insertQuery)
        .beanMapped()
        .build()

}
