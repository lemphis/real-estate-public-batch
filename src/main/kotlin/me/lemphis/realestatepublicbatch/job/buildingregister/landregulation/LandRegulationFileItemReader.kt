package me.lemphis.realestatepublicbatch.job.buildingregister.landregulation

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class LandRegulationFileItemReader {

    @Bean
    fun landRegulationFlatFileItemReader() = FlatFileItemReaderBuilder<LandRegulationFileSpec>()
        .name("landRegulationFlatFileItemReader")
        .encoding("EUC-KR")
        .targetType(LandRegulationFileSpec::class.java)
        .resource(FileSystemResource("/var/buildingregister/land_regulation.txt"))
        .delimited().delimiter("|").names(
            "관리건축물대장PK",
            "대지위치",
            "도로명대지위치",
            "시군구코드",
            "법정동코드",
            "대지구분코드",
            "번",
            "지",
            "특수지명",
            "블록",
            "로트",
            "지역지구구역구분코드",
            "지역지구구역구분코드명",
            "지역지구구역코드",
            "지역지구구역코드명",
            "대표여부",
            "기타지역지구구역",
            "생성일자",
        )
        .build()

}
