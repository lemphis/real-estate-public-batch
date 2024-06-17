package me.lemphis.realestatepublicbatch.land

import java.math.BigDecimal
import java.time.LocalDate

data class LandFileSpec(
	var 고유번호: String? = null,
	var 법정동코드: String? = null,
	var 법정동명: String? = null,
	var 지번: String? = null,
	var 대장구분코드: String? = null,
	var 대장구분명: String? = null,
	var 지목코드: String? = null,
	var 지목명: String? = null,
	var 면적: BigDecimal? = null,
	var 소유구분코드: String? = null,
	var 소유구분명: String? = null,
	var 소유인수: Int? = null,
	var 축척구분코드: String? = null,
	var 축척구분명: String? = null,
	var 데이터기준일자: String? = null,
	var 원천시도시군구코드: String? = null,
) {
	fun toLand() = Land(
		고유번호 = 고유번호!!.trim(),
		법정동코드 = 법정동코드?.ifBlank { null },
		법정동명 = 법정동명?.ifBlank { null },
		지번 = 지번?.ifBlank { null },
		대장구분코드 = 대장구분코드?.ifBlank { null },
		대장구분명 = 대장구분명?.ifBlank { null },
		지목코드 = 지목코드?.ifBlank { null },
		지목명 = 지목명?.ifBlank { null },
		면적 = 면적,
		소유구분코드 = 소유구분코드?.ifBlank { null },
		소유구분명 = 소유구분명?.ifBlank { null },
		소유인수 = 소유인수,
		축척구분코드 = 축척구분코드?.ifBlank { null },
		축척구분명 = 축척구분명?.ifBlank { null },
		데이터기준일자 = 데이터기준일자?.let { LocalDate.parse(it) },
		원천시도시군구코드 = 원천시도시군구코드?.ifBlank { null },
	)
}
