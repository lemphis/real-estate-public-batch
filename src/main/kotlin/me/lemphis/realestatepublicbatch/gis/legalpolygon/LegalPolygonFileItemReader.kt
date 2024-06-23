package me.lemphis.realestatepublicbatch.gis.legalpolygon

import me.lemphis.realestatepublicbatch.gis.ShapeFileItemReader
import org.geotools.api.feature.simple.SimpleFeature
import org.locationtech.jts.geom.MultiPolygon
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.util.Date

@Configuration
class LegalPolygonFileItemReader {

	@Bean
	fun legalPolygonMultiFileItemReader() = MultiResourceItemReaderBuilder<LegalPolygonFileSpec>()
		.name("legalPolygonMultiFileItemReader")
		.resources(*PathMatchingResourcePatternResolver().getResources("file:/var/gis/legalpolygon/**/*.shp"))
		.delegate(legalPolygonFileItemReaderDelegate())
		.build()

	private fun legalPolygonFileItemReaderDelegate() = object : ShapeFileItemReader<LegalPolygonFileSpec>() {
		override fun toShapeFileSpec(feature: SimpleFeature) = LegalPolygonFileSpec(
			법정동코드 = feature.getAttribute("A1") as String,
			polygon = feature.getAttribute("the_geom") as MultiPolygon,
			원천도형ID = feature.getAttribute("A0") as Int,
			지역명 = feature.getAttribute("A2") as String?,
			데이터기준일자 = feature.getAttribute("A3") as Date,
			원천시도시군구코드 = feature.getAttribute("A4") as String,
		)
	}

}
