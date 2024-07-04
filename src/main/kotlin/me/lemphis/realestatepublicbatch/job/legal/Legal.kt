package me.lemphis.realestatepublicbatch.job.legal

import java.time.LocalDate

data class Legal(
	val 법정동코드: String,
	val 시도명: String,
	val 시군구명: String?,
	val 읍면동명: String?,
	val 리명: String?,
	val 순위: Int,
	val 삭제일자: LocalDate?,
	val 생성일자: LocalDate?,
	val 과거법정동코드: String?,
)
