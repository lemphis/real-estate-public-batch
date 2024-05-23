package me.lemphis.realestatepublicbatch.buildingregister.unit

import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class UnitItemProcessor : ItemProcessor<UnitFileSpec, Unit> {

	override fun process(unitFileSpec: UnitFileSpec): Unit? {
		return if (validateUnit(unitFileSpec)) unitFileSpec.toUnit() else null
	}

	private fun validateUnit(unitFileSpec: UnitFileSpec): Boolean {
		if (unitFileSpec.시군구코드.isNullOrBlank() || unitFileSpec.법정동코드.isNullOrBlank() || unitFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (unitFileSpec.시군구코드!!.length < 5 || unitFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (unitFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
