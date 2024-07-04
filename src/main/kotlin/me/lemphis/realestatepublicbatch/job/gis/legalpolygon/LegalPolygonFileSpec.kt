package me.lemphis.realestatepublicbatch.job.gis.legalpolygon

import org.locationtech.jts.geom.MultiPolygon
import org.locationtech.jts.io.WKTWriter
import java.time.ZoneId
import java.util.Date

data class LegalPolygonFileSpec(
	val 법정동코드: String,
	val polygon: MultiPolygon,
	val 원천도형ID: Int,
	val 지역명: String?,
	val 데이터기준일자: Date,
	val 원천시도시군구코드: String,
) {
	fun toLegalPolygon(): LegalPolygon {
		val wktWriter = WKTWriter()
		return LegalPolygon(
			법정동코드 = 법정동코드.trim(),
			polygon = wktWriter.write(polygon),
			원천도형ID = 원천도형ID,
			지역명 = 지역명?.trim()?.ifEmpty { null },
			데이터기준일자 = 데이터기준일자.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
			원천시도시군구코드 = 원천시도시군구코드.trim(),
		)
	}
}
