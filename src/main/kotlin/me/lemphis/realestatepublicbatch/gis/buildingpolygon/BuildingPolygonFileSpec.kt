package me.lemphis.realestatepublicbatch.gis.buildingpolygon

import org.locationtech.jts.geom.MultiPolygon
import org.locationtech.jts.io.WKTWriter
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

data class BuildingPolygonFileSpec(
	val polygon: MultiPolygon?,
	val 원천도형ID: Int,
	val GIS건물통합식별번호: String?,
	val 고유번호: String,
	val 법정동코드: String,
	val 법정동명: String,
	val 지번: String,
	val 특수지코드: String,
	val 특수지구분명: String,
	val 건축물용도코드: String?,
	val 건축물용도명: String,
	val 건축물구조코드: String?,
	val 건축물구조명: String,
	val 건축물면적: Double?,
	val 사용승인일자: String,
	val 연면적: Double?,
	val 대지면적: Double?,
	val 높이: Double?,
	val 건폐율: Double?,
	val 용적율: Double?,
	val 건축물ID: String?,
	val 위반건축물여부: String,
	val 참조체계연계키: String?,
	val 데이터기준일자: Date,
	val 원천시도시군구코드: String,
	val 건물명: String?,
	val 건물동명: String?,
	val 지상층수: Int?,
	val 지하층수: Int?,
	val 데이터생성변경일자: String,
) {
	fun toBuildingPolygon(): BuildingPolygon {
		val wktWriter = WKTWriter()
		return BuildingPolygon(
			polygon = if (polygon != null) wktWriter.write(polygon) else null,
			원천도형ID = 원천도형ID,
			GIS건물통합식별번호 = GIS건물통합식별번호?.ifBlank { null },
			고유번호 = 고유번호.trim(),
			법정동코드 = 법정동코드.trim(),
			법정동명 = 법정동명.ifBlank { null },
			지번 = 지번.trim(),
			특수지코드 = 특수지코드.trim(),
			특수지구분명 = 특수지구분명.trim(),
			건축물용도코드 = 건축물용도코드?.ifBlank { null },
			건축물용도명 = 건축물용도명.ifBlank { null },
			건축물구조코드 = 건축물구조코드?.ifBlank { null },
			건축물구조명 = 건축물구조명.ifBlank { null },
			건축물면적 = if (건축물면적 != null) BigDecimal(건축물면적) else null,
			사용승인일자 = if (사용승인일자.isNotBlank()) LocalDate.parse(사용승인일자) else null,
			연면적 = if (연면적 != null) BigDecimal(연면적) else null,
			대지면적 = if (대지면적 != null) BigDecimal(대지면적) else null,
			높이 = if (높이 != null) BigDecimal(높이) else null,
			건폐율 = if (건폐율 != null) BigDecimal(건폐율) else null,
			용적율 = if (용적율 != null) BigDecimal(용적율) else null,
			건축물ID = 건축물ID?.ifBlank { null },
			위반건축물여부 = 위반건축물여부.ifBlank { null },
			참조체계연계키 = 참조체계연계키?.ifBlank { null },
			데이터기준일자 = 데이터기준일자.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
			원천시도시군구코드 = 원천시도시군구코드.trim(),
			건물명 = 건물명?.ifBlank { null },
			건물동명 = 건물동명?.ifBlank { null },
			지상층수 = 지상층수,
			지하층수 = 지하층수,
			데이터생성변경일자 = if (데이터생성변경일자.trim().isNotBlank()) LocalDate.parse(데이터생성변경일자) else null,
		)
	}
}
