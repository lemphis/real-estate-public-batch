package me.lemphis.apartmentsalesstatistics.job.legalcode

import java.time.LocalDate

data class LegalCode(
	val code: String,
	val sido: String,
	val sigungu: String?,
	val eupmyeondong: String?,
	val ri: String?,
	val createdAt: LocalDate?,
)
