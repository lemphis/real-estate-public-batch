package me.lemphis.realestatepublicbatch.buildingregister.summary

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class SummaryItemProcessor : ItemProcessor<SummaryFileSpec, Summary> {

	override fun process(summaryFileSpec: SummaryFileSpec): Summary? {
		return if (validateSummary(summaryFileSpec)) summaryFileSpec.toSummary() else null
	}

	private fun validateSummary(summaryFileSpec: SummaryFileSpec): Boolean {
		if (summaryFileSpec.시군구코드.isNullOrBlank() || summaryFileSpec.법정동코드.isNullOrBlank() || summaryFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (summaryFileSpec.시군구코드!!.length < 5 || summaryFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (summaryFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
