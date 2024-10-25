package me.lemphis.realestatepublicbatch.job.land

import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LandItemWriter(
    private val dataSource: DataSource,
) {
    val insertQuery = """
		INSERT INTO service.land (고유번호,
                          법정동코드,
                          법정동명,
                          지번,
                          대장구분코드,
                          대장구분명,
                          지목코드,
                          지목명,
                          면적,
                          소유구분코드,
                          소유구분명,
                          소유인수,
                          축척구분코드,
                          축척구분명,
                          데이터기준일자,
                          원천시도시군구코드)
		VALUES (:고유번호,
				:법정동코드,
				:법정동명,
				:지번,
				:대장구분코드,
				:대장구분명,
				:지목코드,
				:지목명,
				:면적,
				:소유구분코드,
				:소유구분명,
				:소유인수,
				:축척구분코드,
				:축척구분명,
				:데이터기준일자,
				:원천시도시군구코드)
		ON DUPLICATE KEY UPDATE 법정동코드     = VALUES(법정동코드),
								법정동명      = VALUES(법정동명),
								지번        = VALUES(지번),
								대장구분코드    = VALUES(대장구분코드),
								대장구분명     = VALUES(대장구분명),
								지목코드      = VALUES(지목코드),
								지목명       = VALUES(지목명),
								면적        = VALUES(면적),
								소유구분코드    = VALUES(소유구분코드),
								소유구분명     = VALUES(소유구분명),
								소유인수      = VALUES(소유인수),
								축척구분코드    = VALUES(축척구분코드),
								축척구분명     = VALUES(축척구분명),
								데이터기준일자   = VALUES(데이터기준일자),
								원천시도시군구코드 = VALUES(원천시도시군구코드)
	""".trimIndent()

    @Bean
    fun landJdbcBatchItemWriter() = JdbcBatchItemWriterBuilder<Land>()
        .dataSource(dataSource)
        .sql(insertQuery)
        .beanMapped()
        .build()

}
