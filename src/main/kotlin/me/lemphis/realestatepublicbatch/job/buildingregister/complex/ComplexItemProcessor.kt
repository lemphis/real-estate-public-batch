package me.lemphis.realestatepublicbatch.job.buildingregister.complex

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class ComplexItemProcessor : ItemProcessor<ComplexFileSpec, Complex> {

	override fun process(complexFileSpec: ComplexFileSpec): Complex? {
		return if (validateComplex(complexFileSpec)) complexFileSpec.toComplex() else null
	}

	private fun validateComplex(complexFileSpec: ComplexFileSpec): Boolean {
		if (complexFileSpec.시군구코드.isNullOrBlank() || complexFileSpec.법정동코드.isNullOrBlank() || complexFileSpec.생성일자.isNullOrBlank()) {
			return false
		}
		if (complexFileSpec.시군구코드!!.length < 5 || complexFileSpec.법정동코드!!.length < 5) {
			return false
		}
		if (complexFileSpec.생성일자!!.length < 8) {
			return false
		}
		return true
	}

}
