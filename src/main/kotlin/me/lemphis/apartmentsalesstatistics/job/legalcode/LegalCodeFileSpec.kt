package me.lemphis.apartmentsalesstatistics.job.legalcode

import java.time.LocalDate

data class LegalCodeFileSpec(
	val code: String,
	val sido: String,
	val sigungu: String?,
	val eupmyeondong: String?,
	val ri: String?,
	val rank: Int?,
	val createdAt: LocalDate?,
	val deletedAt: LocalDate?,
	val beforeLegalCode: String?,
) {
	fun toLegalCode() = LegalCode(
		code = this.code,
		sido = this.sido,
		sigungu = this.sigungu,
		eupmyeondong = this.eupmyeondong,
		ri = this.ri,
		createdAt = this.createdAt,
	)
}
