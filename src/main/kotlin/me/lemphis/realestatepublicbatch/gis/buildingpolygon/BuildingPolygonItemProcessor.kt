package me.lemphis.realestatepublicbatch.gis.buildingpolygon

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class BuildingPolygonItemProcessor : ItemProcessor<BuildingPolygonFileSpec, BuildingPolygon> {

	override fun process(buildingPolygonFileSpec: BuildingPolygonFileSpec): BuildingPolygon? {
		return if (validateBuildingPolygon(buildingPolygonFileSpec)) buildingPolygonFileSpec.toBuildingPolygon() else null
	}

	private fun validateBuildingPolygon(buildingPolygonFileSpec: BuildingPolygonFileSpec): Boolean {
		return buildingPolygonFileSpec.GIS건물통합식별번호.length == 28
			&& buildingPolygonFileSpec.고유번호.length == 19
			&& buildingPolygonFileSpec.법정동코드.length == 10
	}

}
