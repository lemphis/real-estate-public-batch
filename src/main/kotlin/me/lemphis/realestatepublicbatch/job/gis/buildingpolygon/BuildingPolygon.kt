package me.lemphis.realestatepublicbatch.job.gis.buildingpolygon

import java.math.BigDecimal
import java.time.LocalDate

data class BuildingPolygon(
	val polygon: String?,
	val 원천도형ID: Int,
	val GIS건물통합식별번호: String?,
	val 고유번호: String,
	val 법정동코드: String,
	val 법정동명: String?,
	val 지번: String,
	val 특수지코드: String,
	val 특수지구분명: String,
	val 건축물용도코드: String?,
	val 건축물용도명: String?,
	val 건축물구조코드: String?,
	val 건축물구조명: String?,
	val 건축물면적: BigDecimal?,
	val 사용승인일자: LocalDate?,
	val 연면적: BigDecimal?,
	val 대지면적: BigDecimal?,
	val 높이: BigDecimal?,
	val 건폐율: BigDecimal?,
	val 용적율: BigDecimal?,
	val 건축물ID: String?,
	val 위반건축물여부: String?,
	val 참조체계연계키: String?,
	val 데이터기준일자: LocalDate,
	val 원천시도시군구코드: String,
	val 건물명: String?,
	val 건물동명: String?,
	val 지상층수: Int?,
	val 지하층수: Int?,
	val 데이터생성변경일자: LocalDate?,
)
