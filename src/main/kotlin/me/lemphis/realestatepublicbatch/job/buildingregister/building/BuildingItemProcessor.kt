package me.lemphis.realestatepublicbatch.job.buildingregister.building

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class BuildingItemProcessor : ItemProcessor<BuildingFileSpec, Building> {

    override fun process(buildingFileSpec: BuildingFileSpec): Building? {
        return if (validateBuilding(buildingFileSpec)) buildingFileSpec.toBuilding() else null
    }

    private fun validateBuilding(buildingFileSpec: BuildingFileSpec): Boolean {
        if (buildingFileSpec.시군구코드.isNullOrBlank() || buildingFileSpec.법정동코드.isNullOrBlank() || buildingFileSpec.생성일자.isNullOrBlank()) {
            return false
        }
        if (buildingFileSpec.시군구코드!!.length < 5 || buildingFileSpec.법정동코드!!.length < 5) {
            return false
        }
        if (buildingFileSpec.생성일자!!.length < 8) {
            return false
        }
        return true
    }

}
