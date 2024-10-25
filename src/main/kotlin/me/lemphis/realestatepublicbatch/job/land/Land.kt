package me.lemphis.realestatepublicbatch.job.land

import java.math.BigDecimal
import java.time.LocalDate

data class Land(
    val 고유번호: String,
    val 법정동코드: String? = null,
    val 법정동명: String? = null,
    val 지번: String? = null,
    val 대장구분코드: String? = null,
    val 대장구분명: String? = null,
    val 지목코드: String? = null,
    val 지목명: String? = null,
    val 면적: BigDecimal? = null,
    val 소유구분코드: String? = null,
    val 소유구분명: String? = null,
    val 소유인수: Int? = null,
    val 축척구분코드: String? = null,
    val 축척구분명: String? = null,
    val 데이터기준일자: LocalDate? = null,
    val 원천시도시군구코드: String? = null,
)
