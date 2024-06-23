package me.lemphis.realestatepublicbatch.gis.legalpolygon

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class LegalPolygonItemProcessor : ItemProcessor<LegalPolygonFileSpec, LegalPolygon> {

	override fun process(legalPolygonFileSpec: LegalPolygonFileSpec): LegalPolygon? {
		return if (validateLegalPolygon(legalPolygonFileSpec)) legalPolygonFileSpec.toLegalPolygon() else null
	}

	private fun validateLegalPolygon(legalPolygonFileSpec: LegalPolygonFileSpec): Boolean {
		return legalPolygonFileSpec.지역명 != null
	}

}
