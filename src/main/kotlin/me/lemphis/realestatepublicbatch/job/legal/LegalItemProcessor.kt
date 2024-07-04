package me.lemphis.realestatepublicbatch.job.legal

import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class LegalItemProcessor : ItemProcessor<LegalApiContent, Legal> {

	override fun process(legalApiContent: LegalApiContent): Legal? {
		return if (validateLegal(legalApiContent)) legalApiContent.toLegal() else null
	}

	private fun validateLegal(legalApiContent: LegalApiContent): Boolean {
		return true
	}

}
