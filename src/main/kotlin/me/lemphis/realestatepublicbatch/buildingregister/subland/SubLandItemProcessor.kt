package me.lemphis.realestatepublicbatch.buildingregister.subland

import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class SubLandItemProcessor : ItemProcessor<SubLandFileSpec, SubLand> {

	override fun process(subLandFileSpec: SubLandFileSpec): SubLand? {
		return if (validateSubLand(subLandFileSpec)) subLandFileSpec.toSubLand() else null
	}

	private fun validateSubLand(subLandFileSpec: SubLandFileSpec): Boolean {
		if (subLandFileSpec.시군구코드.isNullOrBlank() || subLandFileSpec.법정동코드.isNullOrBlank() || subLandFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (subLandFileSpec.시군구코드!!.length < 5 || subLandFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (subLandFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
