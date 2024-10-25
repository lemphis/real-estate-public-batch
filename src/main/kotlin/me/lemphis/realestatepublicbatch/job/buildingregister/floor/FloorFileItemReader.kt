package me.lemphis.realestatepublicbatch.job.buildingregister.floor

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class FloorFileItemReader {

    @Bean
    fun floorFlatFileItemReader() = FlatFileItemReaderBuilder<FloorFileSpec>()
        .name("floorFlatFileItemReader")
        .encoding("EUC-KR")
        .targetType(FloorFileSpec::class.java)
        .resource(FileSystemResource("/var/buildingregister/floor.txt"))
        .delimited().delimiter("|").names(
            "관리건축물대장PK",
            "대지위치",
            "도로명대지위치",
            "건물명",
            "시군구코드",
            "법정동코드",
            "대지구분코드",
            "번",
            "지",
            "특수지명",
            "블록",
            "로트",
            "새주소도로코드",
            "새주소법정동코드",
            "새주소지상지하코드",
            "새주소본번",
            "새주소부번",
            "동명",
            "층구분코드",
            "층구분코드명",
            "층번호",
            "층번호명",
            "구조코드",
            "구조코드명",
            "기타구조",
            "주용도코드",
            "주용도코드명",
            "기타용도",
            "면적",
            "주부속구분코드",
            "주부속구분코드명",
            "면적제외여부",
            "생성일자",
        )
        .build()

}
