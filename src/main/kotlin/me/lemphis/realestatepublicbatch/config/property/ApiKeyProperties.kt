package me.lemphis.realestatepublicbatch.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "api-key")
data class ApiKeyProperties(
	val dataGoKr: String,
)
