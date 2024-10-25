package me.lemphis.realestatepublicbatch.job.buildingregister.owner

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class OwnerFileItemReader {

	@Bean
	fun ownerFlatFileItemReader() = FlatFileItemReaderBuilder<OwnerFileSpec>()
		.name("ownerFlatFileItemReader")
		.encoding("EUC-KR")
		.targetType(OwnerFileSpec::class.java)
		.resource(FileSystemResource("/var/buildingregister/owner.txt"))
		.delimited().delimiter("|").names(
			"관리건축물대장PK",
			"시군구코드",
			"시군구명",
			"법정동코드",
			"법정동명",
			"대지구분코드",
			"대지구분명",
			"번",
			"지",
			"특수지명",
			"블록",
			"로트",
			"새주소대지위치",
			"새주소도로코드",
			"새주소법정동코드",
			"새주소지상지하코드",
			"새주소지상지하명",
			"새주소본번",
			"새주소부번",
			"대장구분코드",
			"대장구분명",
			"대장종류코드",
			"대장종류명",
			"건물명",
			"동명칭",
			"호명칭",
			"면적",
			"소유구분코드",
			"소유구분명",
			"변동원인일",
		)
		.build()

}
