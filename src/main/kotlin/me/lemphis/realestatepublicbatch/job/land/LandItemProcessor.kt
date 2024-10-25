package me.lemphis.realestatepublicbatch.job.land

import org.springframework.batch.item.ItemProcessor
import org.springframework.context.annotation.Configuration

@Configuration
class LandItemProcessor : ItemProcessor<LandFileSpec, Land> {

    override fun process(landFileSpec: LandFileSpec): Land? {
        return if (validateLand(landFileSpec)) landFileSpec.toLand() else null
    }

    private fun validateLand(landFileSpec: LandFileSpec): Boolean {
        return landFileSpec.고유번호!!.length == 19
    }

}
