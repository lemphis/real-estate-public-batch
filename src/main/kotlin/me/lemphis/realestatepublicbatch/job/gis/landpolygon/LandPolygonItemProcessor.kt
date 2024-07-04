package me.lemphis.realestatepublicbatch.job.gis.landpolygon

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class LandPolygonItemProcessor : ItemProcessor<LandPolygonFileSpec, LandPolygon> {

	override fun process(landPolygonFileSpec: LandPolygonFileSpec): LandPolygon? {
		return if (validateLandPolygon(landPolygonFileSpec)) landPolygonFileSpec.toLandPolygon() else null
	}

	private fun validateLandPolygon(landPolygonFileSpec: LandPolygonFileSpec): Boolean {
		return landPolygonFileSpec.고유번호.length == 19
			&& landPolygonFileSpec.법정동코드.length == 10
			&& landPolygonFileSpec.polygon != null
	}

}
