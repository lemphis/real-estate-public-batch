package me.lemphis.realestatepublicbatch.job.buildingregister.landregulation

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class LandRegulationItemProcessor : ItemProcessor<LandRegulationFileSpec, LandRegulation> {

    override fun process(landRegulationFileSpec: LandRegulationFileSpec): LandRegulation? {
        return if (validateLandRegulation(landRegulationFileSpec)) landRegulationFileSpec.toLandRegulation() else null
    }

    private fun validateLandRegulation(landRegulationFileSpec: LandRegulationFileSpec): Boolean {
        if (landRegulationFileSpec.시군구코드.isNullOrBlank() || landRegulationFileSpec.법정동코드.isNullOrBlank() || landRegulationFileSpec.생성일자.isNullOrBlank()) {
            return false
        }
        if (landRegulationFileSpec.시군구코드!!.length < 5 || landRegulationFileSpec.법정동코드!!.length < 5) {
            return false
        }
        if (landRegulationFileSpec.생성일자!!.length < 8) {
            return false
        }
        return true
    }

}
