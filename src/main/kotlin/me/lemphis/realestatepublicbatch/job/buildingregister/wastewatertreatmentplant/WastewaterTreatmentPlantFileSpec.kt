package me.lemphis.realestatepublicbatch.job.buildingregister.wastewatertreatmentplant

import java.math.BigDecimal

data class WastewaterTreatmentPlantFileSpec(
    var 관리건축물대장PK: String? = null,
    var 대장구분코드: String? = null,
    var 대장구분코드명: String? = null,
    var 대장종류코드: String? = null,
    var 대장종류코드명: String? = null,
    var 대지위치: String? = null,
    var 도로명대지위치: String? = null,
    var 건물명: String? = null,
    var 시군구코드: String? = null,
    var 법정동코드: String? = null,
    var 대지구분코드: String? = null,
    var 번: String? = null,
    var 지: String? = null,
    var 특수지명: String? = null,
    var 블록: String? = null,
    var 로트: String? = null,
    var 새주소도로코드: String? = null,
    var 새주소법정동코드: String? = null,
    var 새주소지상지하코드: String? = null,
    var 새주소본번: Int? = null,
    var 새주소부번: Int? = null,
    var 형식코드: String? = null,
    var 형식코드명: String? = null,
    var 기타형식: String? = null,
    var 단위구분코드: String? = null,
    var 단위구분코드명: String? = null,
    var 용량인용: BigDecimal? = null,
    var 용량루베: BigDecimal? = null,
    var 생성일자: String? = null,
) {
    fun toWastewaterTreatmentPlant() = WastewaterTreatmentPlant(
        관리건축물대장PK = 관리건축물대장PK!!.trim(),
        대장구분코드 = 대장구분코드?.trim()?.ifEmpty { null },
        대장구분코드명 = 대장구분코드명?.trim()?.ifEmpty { null },
        대장종류코드 = 대장종류코드?.trim()?.ifEmpty { null },
        대장종류코드명 = 대장종류코드명?.trim()?.ifEmpty { null },
        대지위치 = 대지위치?.trim()?.ifEmpty { null },
        도로명대지위치 = 도로명대지위치?.trim()?.ifEmpty { null },
        건물명 = 건물명?.trim()?.ifEmpty { null },
        시군구코드 = 시군구코드?.trim()?.ifEmpty { null },
        법정동코드 = 법정동코드?.trim()?.ifEmpty { null },
        대지구분코드 = 대지구분코드?.trim()?.ifEmpty { null },
        번 = 번?.trim()?.ifEmpty { null },
        지 = 지?.trim()?.ifEmpty { null },
        특수지명 = 특수지명?.trim()?.ifEmpty { null },
        블록 = 블록?.trim()?.ifEmpty { null },
        로트 = 로트?.trim()?.ifEmpty { null },
        새주소도로코드 = 새주소도로코드?.trim()?.ifEmpty { null },
        새주소법정동코드 = 새주소법정동코드?.trim()?.ifEmpty { null },
        새주소지상지하코드 = 새주소지상지하코드?.trim()?.ifEmpty { null },
        새주소본번 = 새주소본번,
        새주소부번 = 새주소부번,
        형식코드 = 형식코드?.trim()?.ifEmpty { null },
        형식코드명 = 형식코드명?.trim()?.ifEmpty { null },
        기타형식 = 기타형식?.trim()?.ifEmpty { null },
        단위구분코드 = 단위구분코드?.trim()?.ifEmpty { null },
        단위구분코드명 = 단위구분코드명?.trim()?.ifEmpty { null },
        용량인용 = 용량인용,
        용량루베 = 용량루베,
        생성일자 = 생성일자?.trim()?.ifEmpty { null },
    )
}
