package me.lemphis.realestatepublicbatch.job.buildingregister.wastewatertreatmentplant

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class WastewaterTreatmentPlantItemProcessor :
	ItemProcessor<WastewaterTreatmentPlantFileSpec, WastewaterTreatmentPlant> {

	override fun process(wastewaterTreatmentPlantFileSpec: WastewaterTreatmentPlantFileSpec): WastewaterTreatmentPlant? {
		return if (validateWastewaterTreatmentPlant(wastewaterTreatmentPlantFileSpec)) wastewaterTreatmentPlantFileSpec.toWastewaterTreatmentPlant() else null
	}

	private fun validateWastewaterTreatmentPlant(wastewaterTreatmentPlantFileSpec: WastewaterTreatmentPlantFileSpec): Boolean {
		if (wastewaterTreatmentPlantFileSpec.시군구코드.isNullOrBlank() || wastewaterTreatmentPlantFileSpec.법정동코드.isNullOrBlank() || wastewaterTreatmentPlantFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (wastewaterTreatmentPlantFileSpec.시군구코드!!.length < 5 || wastewaterTreatmentPlantFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (wastewaterTreatmentPlantFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
