package me.lemphis.realestatepublicbatch.job.legal.code.api

import me.lemphis.realestatepublicbatch.batch.reader.ApiPagingItemReader
import me.lemphis.realestatepublicbatch.config.property.ApiKeyProperties
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class LegalApiItemReader(
    private val odcloudRestClient: RestClient,
    private val apiKeyProperties: ApiKeyProperties,
) : ApiPagingItemReader<LegalApiContent>() {
    override fun doRead(page: Int, pageSize: Int): List<LegalApiContent> {
        val response = odcloudRestClient.get()
            .uri {
                it.path("/api/15063424/v1/uddi:6d7fd177-cc7d-426d-ba80-9b137edf6066")
                    .queryParam("serviceKey", apiKeyProperties.dataGoKr)
                    .queryParam("page", page)
                    .queryParam("perPage", pageSize)
                    .build()
            }
            .retrieve()
            .body(LegalApiSpec::class.java)!!
        return response.data
    }
}
