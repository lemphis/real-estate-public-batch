package me.lemphis.realestatepublicbatch.buildingregister.landregulation

data class LandRegulation(
	val 관리건축물대장PK: String,
	val 대지위치: String? = null,
	val 도로명대지위치: String? = null,
	val 시군구코드: String? = null,
	val 법정동코드: String? = null,
	val 대지구분코드: String? = null,
	val 번: String? = null,
	val 지: String? = null,
	val 특수지명: String? = null,
	val 블록: String? = null,
	val 로트: String? = null,
	val 지역지구구역구분코드: String? = null,
	val 지역지구구역구분코드명: String? = null,
	val 지역지구구역코드: String? = null,
	val 지역지구구역코드명: String? = null,
	val 대표여부: String? = null,
	val 기타지역지구구역: String? = null,
	val 생성일자: String? = null,
)
