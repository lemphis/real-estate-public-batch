package me.lemphis.realestatepublicbatch.job.legal

import me.lemphis.realestatepublicbatch.batch.reader.ApiPagingItemReader
import me.lemphis.realestatepublicbatch.config.property.ApiKeyProperties
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class LegalApiItemReader(
	private val restClient: RestClient,
	private val apiKeyProperties: ApiKeyProperties,
) : ApiPagingItemReader<LegalApiContent>() {
	override fun doRead(page: Int, pageSize: Int): List<LegalApiContent> {
		return restClient.get()
			.uri {
				it.scheme("https")
					.host("api.odcloud.kr")
					.path("/api/15063424/v1/uddi:6d7fd177-cc7d-426d-ba80-9b137edf6066")
					.queryParam("serviceKey", apiKeyProperties.dataGoKr)
					.queryParam("page", page)
					.queryParam("perPage", pageSize)
					.build()
			}
			.retrieve()
			.body(LegalApiSpec::class.java)
			?.data ?: throw IllegalStateException()
	}
}
