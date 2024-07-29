package me.lemphis.realestatepublicbatch.config.webclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

	@Bean
	fun odcloudRestClient() = RestClient.builder()
		.baseUrl("https://api.odcloud.kr")
		.defaultHeaders { it.accept = listOf(MediaType.APPLICATION_JSON) }
		.build()

	@Bean
	fun dataRestClient() = RestClient.builder()
		.baseUrl("https://apis.data.go.kr")
		.defaultHeaders { it.accept = listOf(MediaType.APPLICATION_JSON) }
		.build()

}
