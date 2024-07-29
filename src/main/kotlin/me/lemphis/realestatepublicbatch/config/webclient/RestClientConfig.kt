package me.lemphis.realestatepublicbatch.config.webclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

	@Bean
	fun restClient() = RestClient.builder()
		.defaultHeaders { it.accept = listOf(MediaType.APPLICATION_JSON) }
		.build()

}
