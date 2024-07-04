package me.lemphis.realestatepublicbatch.job.buildingregister.floor

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class FloorItemProcessor : ItemProcessor<FloorFileSpec, Floor> {

	override fun process(floorFileSpec: FloorFileSpec): Floor? {
		return if (validateFloor(floorFileSpec)) floorFileSpec.toFloor() else null
	}

	private fun validateFloor(floorFileSpec: FloorFileSpec): Boolean {
		if (floorFileSpec.시군구코드.isNullOrBlank() || floorFileSpec.법정동코드.isNullOrBlank() || floorFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (floorFileSpec.시군구코드!!.length < 5 || floorFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (floorFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
