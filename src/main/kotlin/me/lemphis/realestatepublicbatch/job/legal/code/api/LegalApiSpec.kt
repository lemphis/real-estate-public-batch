package me.lemphis.realestatepublicbatch.job.legal.code.api

import java.time.LocalDate

data class LegalApiSpec(
	val currentCount: Int,
	val data: List<LegalApiContent>,
)

data class LegalApiContent(
	val 법정동코드: String,
	val 시도명: String,
	val 시군구명: String?,
	val 읍면동명: String?,
	val 리명: String?,
	val 순위: Int,
	val 삭제일자: LocalDate?,
	val 생성일자: LocalDate?,
	val 과거법정동코드: String?,
) {
	fun toLegal() = Legal(
		법정동코드 = 법정동코드,
		시군구명 = 시군구명,
		시도명 = 시도명,
		읍면동명 = 읍면동명,
		리명 = 리명,
		순위 = 순위,
		삭제일자 = 삭제일자,
		생성일자 = 생성일자,
		과거법정동코드 = 과거법정동코드,
	)
}
