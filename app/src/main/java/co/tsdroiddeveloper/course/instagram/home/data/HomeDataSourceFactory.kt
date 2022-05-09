package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.common.base.Cache
import co.tsdroiddeveloper.course.instagram.common.model.Post

class HomeDataSourceFactory(
    private val feedCache: Cache<List<Post>>
) {
    fun createLocalDataSource(): HomeDataSource {
        return HomeLocalDataSource(feedCache)
    }

    fun createFromFeed(): HomeDataSource {
        if (feedCache.isCached()) {
            return HomeLocalDataSource(feedCache)
        }
        return HomeFakeRemoteDataSource()
    }
}
