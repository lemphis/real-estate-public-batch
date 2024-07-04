package me.lemphis.realestatepublicbatch.job.buildingregister.houseprice

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class HousePriceItemProcessor : ItemProcessor<HousePriceFileSpec, HousePrice> {

	override fun process(housePriceFileSpec: HousePriceFileSpec): HousePrice? {
		return if (validateHousePrice(housePriceFileSpec)) housePriceFileSpec.toHousePrice() else null
	}

	private fun validateHousePrice(housePriceFileSpec: HousePriceFileSpec): Boolean {
		if (housePriceFileSpec.시군구코드.isNullOrBlank() || housePriceFileSpec.법정동코드.isNullOrBlank() || housePriceFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (housePriceFileSpec.시군구코드!!.length < 5 || housePriceFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (housePriceFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
