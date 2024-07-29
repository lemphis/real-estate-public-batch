package me.lemphis.realestatepublicbatch.job.legal.code.file

data class LegalFileSpec(
	var 법정동코드: String? = null,
	var 법정동명: String? = null,
	var 폐지여부: String? = null,
) {
	fun toLegal() = Legal(
		code = 법정동코드!!,
		name = 법정동명!!,
		isActive = if (폐지여부 == "존재") 1 else 0,
	)
}
