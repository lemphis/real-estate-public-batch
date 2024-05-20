package me.lemphis.realestatepublicbatch.buildingregister.summary

data class Summary(
	val 관리건축물대장PK: String,
	val 관리상위건축물대장PK: String? = null,
	val 대장구분코드: String? = null,
	val 대장구분코드명: String? = null,
	val 대장종류코드: String? = null,
	val 대장종류코드명: String? = null,
	val 대지위치: String? = null,
	val 도로명대지위치: String? = null,
	val 건물명: String? = null,
	val 시군구코드: String? = null,
	val 법정동코드: String? = null,
	val 대지구분코드: String? = null,
	val 번: String? = null,
	val 지: String? = null,
	val 특수지명: String? = null,
	val 블록: String? = null,
	val 로트: String? = null,
	val 외필지수: Int? = null,
	val 새주소도로코드: String? = null,
	val 새주소법정동코드: String? = null,
	val 새주소지상지하코드: String? = null,
	val 새주소본번: Int? = null,
	val 새주소부번: Int? = null,
	val 지역코드: String? = null,
	val 지구코드: String? = null,
	val 구역코드: String? = null,
	val 지역코드명: String? = null,
	val 지구코드명: String? = null,
	val 구역코드명: String? = null,
	val 생성일자: String? = null,
)
