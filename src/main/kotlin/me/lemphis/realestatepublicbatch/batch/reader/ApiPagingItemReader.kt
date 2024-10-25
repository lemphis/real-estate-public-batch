package me.lemphis.realestatepublicbatch.batch.reader

import org.springframework.batch.item.ExecutionContext
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemStream

abstract class ApiPagingItemReader<T>(
    private val pageSize: Int = 100,
) : ItemReader<T>, ItemStream {
    private val currentPageKey = "page.current"
    private var currentPage = -1
    private var currentItems = emptyList<T>()
    private var currentItemIndex = 0

    override fun read(): T? {
        if (currentPage == -1 || currentItemIndex >= currentItems.size) {
            this.currentItems = this.doRead(++currentPage, pageSize)
            currentItemIndex = 0
        }
        return if (currentItems.isEmpty()) null else currentItems[currentItemIndex++]
    }

    override fun open(executionContext: ExecutionContext) {
        if (executionContext.containsKey(currentPageKey)) {
            this.currentPage = executionContext.getInt(currentPageKey)
        }
    }

    override fun update(executionContext: ExecutionContext) {
        executionContext.putInt(currentPageKey, this.currentPage)
    }

    abstract fun doRead(page: Int, pageSize: Int): List<T>
}
