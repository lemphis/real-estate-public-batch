package me.lemphis.realestatepublicbatch.job.buildingregister.landregulation

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class LandRegulationItemWriter(
    private val dataSource: DataSource,
) {
    val insertQuery = """
		INSERT INTO service.land_regulation (관리건축물대장PK,
                                     대지위치,
                                     도로명대지위치,
                                     시군구코드,
                                     법정동코드,
                                     대지구분코드,
                                     번,
                                     지,
                                     특수지명,
                                     블록,
                                     로트,
                                     지역지구구역구분코드,
                                     지역지구구역구분코드명,
                                     지역지구구역코드,
                                     지역지구구역코드명,
                                     대표여부,
                                     기타지역지구구역,
                                     생성일자)
		VALUES (:관리건축물대장PK,
				:대지위치,
				:도로명대지위치,
				:시군구코드,
				:법정동코드,
				:대지구분코드,
				:번,
				:지,
				:특수지명,
				:블록,
				:로트,
				:지역지구구역구분코드,
				:지역지구구역구분코드명,
				:지역지구구역코드,
				:지역지구구역코드명,
				:대표여부,
				:기타지역지구구역,
				:생성일자)
		ON DUPLICATE KEY UPDATE 대지위치        = VALUES(대지위치),
								도로명대지위치     = VALUES(도로명대지위치),
								시군구코드       = VALUES(시군구코드),
								법정동코드       = VALUES(법정동코드),
								대지구분코드      = VALUES(대지구분코드),
								번           = VALUES(번),
								지           = VALUES(지),
								특수지명        = VALUES(특수지명),
								블록          = VALUES(블록),
								로트          = VALUES(로트),
								지역지구구역구분코드  = VALUES(지역지구구역구분코드),
								지역지구구역구분코드명 = VALUES(지역지구구역구분코드명),
								지역지구구역코드    = VALUES(지역지구구역코드),
								지역지구구역코드명   = VALUES(지역지구구역코드명),
								대표여부        = VALUES(대표여부),
								기타지역지구구역    = VALUES(기타지역지구구역),
								생성일자        = VALUES(생성일자)
	""".trimIndent()

    @Bean
    fun landRegulationJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<LandRegulation>()
        .dataSource(dataSource)
        .sql(insertQuery)
        .beanMapped()
        .build()

}
