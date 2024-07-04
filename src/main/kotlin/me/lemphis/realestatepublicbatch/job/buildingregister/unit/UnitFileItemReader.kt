package me.lemphis.realestatepublicbatch.job.buildingregister.unit

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class UnitFileItemReader {

	@Bean
	fun unitFlatFileItemReader() = FlatFileItemReaderBuilder<UnitFileSpec>()
		.name("unitFlatFileItemReader")
		.encoding("EUC-KR")
		.targetType(UnitFileSpec::class.java)
		.resource(FileSystemResource("/var/buildingregister/unit.txt"))
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
			"새주소도로코드",
			"새주소법정동코드",
			"새주소지상지하코드",
			"새주소본번",
			"새주소부번",
			"동명",
			"호명",
			"층구분코드",
			"층구분코드명",
			"층번호",
			"생성일자",
		)
		.build()

}
