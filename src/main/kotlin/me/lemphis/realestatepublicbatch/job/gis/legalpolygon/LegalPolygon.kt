package me.lemphis.realestatepublicbatch.job.gis.legalpolygon

import java.time.LocalDate

data class LegalPolygon(
	val 법정동코드: String,
	val polygon: String,
	val 원천도형ID: Int,
	val 지역명: String?,
	val 데이터기준일자: LocalDate,
	val 원천시도시군구코드: String,
)
