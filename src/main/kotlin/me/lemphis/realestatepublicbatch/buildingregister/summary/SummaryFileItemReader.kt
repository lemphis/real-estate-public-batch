package me.lemphis.realestatepublicbatch.buildingregister.summary

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
class SummaryFileItemReader {

	@Bean
	fun summaryFlatFileItemReader() = FlatFileItemReaderBuilder<SummaryFileSpec>()
		.name("summaryFlatFileItemReader")
		.encoding("EUC-KR")
		.targetType(SummaryFileSpec::class.java)
		.resource(ClassPathResource("summary_202403.txt"))
		.delimited().delimiter("|").names(
			"관리건축물대장PK",
			"관리상위건축물대장PK",
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
			"지역코드",
			"지구코드",
			"구역코드",
			"지역코드명",
			"지구코드명",
			"구역코드명",
			"생성일자",
		)
		.build()

}
