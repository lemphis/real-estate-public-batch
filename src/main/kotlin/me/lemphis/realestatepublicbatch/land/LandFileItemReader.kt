package me.lemphis.realestatepublicbatch.land

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver

@Configuration
class LandFileItemReader {

	@Bean
	fun landMultiFileItemReader() = MultiResourceItemReaderBuilder<LandFileSpec>()
		.name("landMultiFileItemReader")
		.resources(*PathMatchingResourcePatternResolver().getResources("file:/var/land/*.csv"))
		.delegate(landFlatFileItemReader())
		.build()

	private fun landFlatFileItemReader() = FlatFileItemReaderBuilder<LandFileSpec>()
		.name("landFlatFileItemReader")
		.encoding("EUC-KR")
		.targetType(LandFileSpec::class.java)
		.linesToSkip(1)
		.delimited().delimiter(",").names(
			"고유번호",
			"법정동코드",
			"법정동명",
			"지번",
			"대장구분코드",
			"대장구분명",
			"지목코드",
			"지목명",
			"면적",
			"소유구분코드",
			"소유구분명",
			"소유인수",
			"축척구분코드",
			"축척구분명",
			"데이터기준일자",
			"원천시도시군구코드",
		)
		.build()

}
