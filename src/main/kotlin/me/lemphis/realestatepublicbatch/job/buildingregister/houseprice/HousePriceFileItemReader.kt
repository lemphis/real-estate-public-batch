package me.lemphis.realestatepublicbatch.job.buildingregister.houseprice

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class HousePriceFileItemReader {

	@Bean
	fun housePriceFlatFileItemReader() = FlatFileItemReaderBuilder<HousePriceFileSpec>()
		.name("housePriceFlatFileItemReader")
		.encoding("EUC-KR")
		.targetType(HousePriceFileSpec::class.java)
		.resource(FileSystemResource("/var/buildingregister/house_price.txt"))
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
			"기준일자",
			"주택가격",
			"생성일자",
		)
		.build()

}
