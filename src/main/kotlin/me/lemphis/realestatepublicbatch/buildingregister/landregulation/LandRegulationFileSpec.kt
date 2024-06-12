package me.lemphis.realestatepublicbatch.buildingregister.landregulation

data class LandRegulationFileSpec(
	var 관리건축물대장PK: String? = null,
	var 대지위치: String? = null,
	var 도로명대지위치: String? = null,
	var 시군구코드: String? = null,
	var 법정동코드: String? = null,
	var 대지구분코드: String? = null,
	var 번: String? = null,
	var 지: String? = null,
	var 특수지명: String? = null,
	var 블록: String? = null,
	var 로트: String? = null,
	var 지역지구구역구분코드: String? = null,
	var 지역지구구역구분코드명: String? = null,
	var 지역지구구역코드: String? = null,
	var 지역지구구역코드명: String? = null,
	var 대표여부: String? = null,
	var 기타지역지구구역: String? = null,
	var 생성일자: String? = null,

	) {
	fun toLandRegulation() = LandRegulation(
		관리건축물대장PK = 관리건축물대장PK!!.trim(),
		대지위치 = 대지위치?.ifBlank { null },
		도로명대지위치 = 도로명대지위치?.ifBlank { null },
		시군구코드 = 시군구코드?.ifBlank { null },
		법정동코드 = 법정동코드?.ifBlank { null },
		대지구분코드 = 대지구분코드?.ifBlank { null },
		번 = 번?.ifBlank { null },
		지 = 지?.ifBlank { null },
		특수지명 = 특수지명?.ifBlank { null },
		블록 = 블록?.ifBlank { null },
		로트 = 로트?.ifBlank { null },
		지역지구구역구분코드 = 지역지구구역구분코드?.ifBlank { null },
		지역지구구역구분코드명 = 지역지구구역구분코드명?.ifBlank { null },
		지역지구구역코드 = 지역지구구역코드?.ifBlank { null },
		지역지구구역코드명 = 지역지구구역코드명?.ifBlank { null },
		대표여부 = 대표여부?.ifBlank { null },
		기타지역지구구역 = 기타지역지구구역?.ifBlank { null },
		생성일자 = 생성일자?.ifBlank { null },
	)
}
