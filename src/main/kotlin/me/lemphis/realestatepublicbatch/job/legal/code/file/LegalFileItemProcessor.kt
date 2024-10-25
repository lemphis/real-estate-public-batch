package me.lemphis.realestatepublicbatch.job.legal.code.file

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class LegalFileItemProcessor : ItemProcessor<LegalFileSpec, Legal> {

    override fun process(legalFileSpec: LegalFileSpec): Legal? {
        return legalFileSpec.takeIf { validateLegal(it) }
            ?.toLegal()
            ?.takeIf { filterLegal(it) }
    }

    private fun validateLegal(legalFileSpec: LegalFileSpec): Boolean {
        return legalFileSpec.법정동명 != null
    }

    private fun filterLegal(legal: Legal): Boolean {
        return legal.isActive
    }

}
