package me.lemphis.realestatepublicbatch.batch.reader

import org.geotools.api.data.DataStore
import org.geotools.api.feature.simple.SimpleFeature
import org.geotools.data.shapefile.ShapefileDataStore
import org.geotools.data.simple.SimpleFeatureIterator
import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream
import org.springframework.core.io.Resource
import java.nio.charset.Charset

abstract class ShapeFileItemReader<T> : ResourceAwareItemReaderItemStream<T> {
	private lateinit var resource: Resource
	private lateinit var dataStore: DataStore
	private lateinit var featureIterator: SimpleFeatureIterator
	private val readCountKey = "read.count"
	private var readCount = 0

	override fun setResource(resource: Resource) {
		this.resource = resource
		this.readCount = 0
	}

	override fun open(executionContext: ExecutionContext) {
		this.dataStore = ShapefileDataStore(resource.url).apply { charset = Charset.forName("EUC-KR") }
		this.featureIterator = (this.dataStore as ShapefileDataStore).featureSource.features.features()
		if (executionContext.containsKey(readCountKey)) {
			this.readCount = executionContext.getInt(readCountKey)
			for (i in 0 until readCount) {
				featureIterator.next()
			}
		}
	}

	override fun update(executionContext: ExecutionContext) {
		executionContext.putInt(readCountKey, this.readCount)
	}

	override fun close() {
		featureIterator.close()
		dataStore.dispose()
	}

	override fun read(): T? {
		if (featureIterator.hasNext()) {
			++readCount
			return toShapeFileSpec(featureIterator.next())
		}
		return null
	}

	abstract fun toShapeFileSpec(feature: SimpleFeature): T
}
