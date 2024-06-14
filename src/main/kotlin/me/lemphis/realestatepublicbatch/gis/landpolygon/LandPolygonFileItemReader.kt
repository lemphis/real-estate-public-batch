package me.lemphis.realestatepublicbatch.gis.landpolygon

import me.lemphis.realestatepublicbatch.gis.ShapeFileItemReader
import org.geotools.api.feature.simple.SimpleFeature
import org.locationtech.jts.geom.MultiPolygon
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.util.Date

@Configuration
class LandPolygonFileItemReader {

	@Bean
	fun landPolygonMultiFileItemReader() = MultiResourceItemReaderBuilder<LandPolygonFileSpec>()
		.name("landPolygonMultiFileItemReader")
		.resources(*PathMatchingResourcePatternResolver().getResources("file:/var/gis/landpolygon/**/*.shp"))
		.delegate(landPolygonFileItemReaderDelegate())
		.build()

	private fun landPolygonFileItemReaderDelegate() = object : ShapeFileItemReader<LandPolygonFileSpec>() {
		override fun toShapeFileSpec(feature: SimpleFeature) = LandPolygonFileSpec(
			고유번호 = feature.getAttribute("A0") as String,
			polygon = feature.getAttribute("the_geom") as MultiPolygon?,
			법정동코드 = feature.getAttribute("A1") as String,
			법정동명 = feature.getAttribute("A2") as String,
			대장구분코드 = feature.getAttribute("A3") as String,
			대장구분명 = feature.getAttribute("A4") as String,
			지번 = feature.getAttribute("A5") as String,
			지번지목부호 = feature.getAttribute("A6") as String?,
			기준연도 = feature.getAttribute("A7") as String?,
			기준월 = feature.getAttribute("A8") as String?,
			개별공시지가 = feature.getAttribute("A9") as Int?,
			표준지여부 = feature.getAttribute("A10") as String?,
			지목코드 = feature.getAttribute("A11") as String?,
			지목 = feature.getAttribute("A12") as String?,
			토지면적 = feature.getAttribute("A13") as Double?,
			데이터기준일자 = feature.getAttribute("A14") as Date,
			원천시도시군구코드 = feature.getAttribute("A15") as String,
			과년도1공시지가 = feature.getAttribute("A16") as Int?,
			과년도2공시지가 = feature.getAttribute("A17") as Int?,
			과년도3공시지가 = feature.getAttribute("A18") as Int?,
			과년도4공시지가 = feature.getAttribute("A19") as Int?,
		)
	}

}
