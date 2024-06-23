package me.lemphis.realestatepublicbatch.gis.landpolygon

import org.locationtech.jts.geom.MultiPolygon
import org.locationtech.jts.io.WKTWriter
import java.math.BigDecimal
import java.time.ZoneId
import java.util.Date

data class LandPolygonFileSpec(
	val 고유번호: String,
	val polygon: MultiPolygon?,
	val 법정동코드: String,
	val 법정동명: String,
	val 대장구분코드: String,
	val 대장구분명: String,
	val 지번: String,
	val 지번지목부호: String?,
	val 기준연도: String?,
	val 기준월: String?,
	val 개별공시지가: Int?,
	val 표준지여부: String?,
	val 지목코드: String?,
	val 지목: String?,
	val 토지면적: Double?,
	val 데이터기준일자: Date,
	val 원천시도시군구코드: String,
	val 과년도1공시지가: Int?,
	val 과년도2공시지가: Int?,
	val 과년도3공시지가: Int?,
	val 과년도4공시지가: Int?,
) {
	fun toLandPolygon(): LandPolygon {
		val wktWriter = WKTWriter()
		return LandPolygon(
			고유번호 = 고유번호.trim(),
			polygon = if (polygon != null) wktWriter.write(polygon) else null,
			법정동코드 = 법정동코드.trim(),
			법정동명 = 고유번호.trim(),
			대장구분코드 = 대장구분코드.trim(),
			대장구분명 = 대장구분명.trim(),
			지번 = 지번.trim(),
			지번지목부호 = 지번지목부호?.trim()?.ifEmpty { null },
			기준연도 = 기준연도?.trim()?.ifEmpty { null },
			기준월 = 기준월?.trim()?.ifEmpty { null },
			개별공시지가 = 개별공시지가,
			표준지여부 = 표준지여부?.trim()?.ifEmpty { null },
			지목코드 = 지목코드?.trim()?.ifEmpty { null },
			지목 = 지목?.trim()?.ifEmpty { null },
			토지면적 = if (토지면적 != null) BigDecimal(토지면적) else null,
			데이터기준일자 = 데이터기준일자.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
			원천시도시군구코드 = 원천시도시군구코드.trim(),
			과년도1공시지가 = 과년도1공시지가,
			과년도2공시지가 = 과년도2공시지가,
			과년도3공시지가 = 과년도3공시지가,
			과년도4공시지가 = 과년도4공시지가,
		)
	}
}
