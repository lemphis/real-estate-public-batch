package me.lemphis.apartmentsalesstatistics.job.aptsales

data class AptSalesApiResponse(
	val response: Response,
) {

	data class Response(
		val header: Header,
		val body: Body,
	)

	data class Header(
		val resultCode: String,
		val resultMsg: String,
	)

	data class Body(
		val items: Items,
	)

	data class Items(
		val item: List<AptSalesItem>,
	)

	data class AptSalesItem(
		val 거래금액: String,
		val 거래유형: String,
		val 건축년도: Int,
		val 년: Int,
		val 등기일자: String?,
		val 법정동: String,
		val 아파트: String,
		val 월: Int,
		val 일: Int,
		val 전용면적: Double,
		val 중개사소재지: String,
		val 지번: String,
		val 지역코드: String,
		val 층: Int,
		val 해제사유발생일: String?,
		val 해제여부: String?,
	)

}
