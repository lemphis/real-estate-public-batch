package me.lemphis.realestatepublicbatch.job.buildingregister.owner

import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

@Component
class OwnerItemProcessor : ItemProcessor<OwnerFileSpec, Owner> {

    override fun process(ownerFileSpec: OwnerFileSpec): Owner? {
        return if (validateOwner(ownerFileSpec)) ownerFileSpec.toOwner() else null
    }

    private fun validateOwner(ownerFileSpec: OwnerFileSpec): Boolean {
        if (ownerFileSpec.시군구코드.isNullOrBlank() || ownerFileSpec.법정동코드.isNullOrBlank()) {
            return false
        }
        if (ownerFileSpec.시군구코드!!.length < 5 || ownerFileSpec.법정동코드!!.length < 5) {
            return false
        }
        return true
    }

}
