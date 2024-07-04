package me.lemphis.realestatepublicbatch.job.gis.landpolygon

import java.math.BigDecimal
import java.time.LocalDate

data class LandPolygon(
	val 고유번호: String,
	val polygon: String?,
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
	val 토지면적: BigDecimal?,
	val 데이터기준일자: LocalDate,
	val 원천시도시군구코드: String,
	val 과년도1공시지가: Int?,
	val 과년도2공시지가: Int?,
	val 과년도3공시지가: Int?,
	val 과년도4공시지가: Int?,
)
