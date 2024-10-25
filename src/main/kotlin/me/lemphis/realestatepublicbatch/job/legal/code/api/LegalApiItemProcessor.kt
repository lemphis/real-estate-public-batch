package me.lemphis.realestatepublicbatch.job.legal.code.api

import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class LegalApiItemProcessor : ItemProcessor<LegalApiContent, Legal> {

    override fun process(legalApiContent: LegalApiContent): Legal? {
        return if (validateLegal(legalApiContent)) legalApiContent.toLegal() else null
    }

    private fun validateLegal(legalApiContent: LegalApiContent): Boolean {
        return true
    }

}
