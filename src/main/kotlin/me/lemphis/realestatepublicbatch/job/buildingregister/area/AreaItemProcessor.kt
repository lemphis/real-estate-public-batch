package me.lemphis.realestatepublicbatch.job.buildingregister.area

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class AreaItemProcessor : ItemProcessor<AreaFileSpec, Area> {

	override fun process(areaFileSpec: AreaFileSpec): Area? {
		return if (validateArea(areaFileSpec)) areaFileSpec.toArea() else null
	}

	private fun validateArea(areaFileSpec: AreaFileSpec): Boolean {
		if (areaFileSpec.시군구코드.isNullOrBlank() || areaFileSpec.법정동코드.isNullOrBlank() || areaFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (areaFileSpec.시군구코드!!.length < 5 || areaFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (areaFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
