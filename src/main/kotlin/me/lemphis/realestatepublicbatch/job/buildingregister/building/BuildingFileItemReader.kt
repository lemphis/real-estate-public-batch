package me.lemphis.realestatepublicbatch.job.buildingregister.building

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class BuildingFileItemReader {

    @Bean
    fun buildingFlatFileItemReader() = FlatFileItemReaderBuilder<BuildingFileSpec>()
        .name("buildingFlatFileItemReader")
        .encoding("EUC-KR")
        .targetType(BuildingFileSpec::class.java)
        .resource(FileSystemResource("/var/buildingregister/building.txt"))
        .delimited().delimiter("|").names(
            "관리건축물대장PK",
            "대장구분코드",
            "대장구분코드명",
            "대장종류코드",
            "대장종류코드명",
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
            "외필지수",
            "새주소도로코드",
            "새주소법정동코드",
            "새주소지상지하코드",
            "새주소본번",
            "새주소부번",
            "동명",
            "주부속구분코드",
            "주부속구분코드명",
            "대지면적",
            "건축면적",
            "건폐율",
            "연면적",
            "용적률산정연면적",
            "용적률",
            "구조코드",
            "구조코드명",
            "기타구조",
            "주용도코드",
            "주용도코드명",
            "기타용도",
            "지붕코드",
            "지붕코드명",
            "기타지붕",
            "세대수",
            "가구수",
            "높이",
            "지상층수",
            "지하층수",
            "승용승강기수",
            "비상용승강기수",
            "부속건축물수",
            "부속건축물면적",
            "총동연면적",
            "옥내기계식대수",
            "옥내기계식면적",
            "옥외기계식대수",
            "옥외기계식면적",
            "옥내자주식대수",
            "옥내자주식면적",
            "옥외자주식대수",
            "옥외자주식면적",
            "허가일",
            "착공일",
            "사용승인일",
            "허가번호년",
            "허가번호기관코드",
            "허가번호기관코드명",
            "허가번호구분코드",
            "허가번호구분코드명",
            "호수",
            "에너지효율등급",
            "에너지절감율",
            "에너지EPI점수",
            "친환경건축물등급",
            "친환경건축물인증점수",
            "지능형건축물등급",
            "지능형건축물인증점수",
            "생성일자",
            "내진설계적용여부",
            "내진능력",
        )
        .build()

}
