package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth
import java.util.*

class HomeRepository(private val dataSourceFactory: HomeDataSourceFactory) {

    fun fetchFeed(callback: RequestCallback<List<Post>>) {
        val localDataSource = dataSourceFactory.createLocalDataSource()
        val userAuth = localDataSource.fetchSession()

        val dataSource = dataSourceFactory.createFromFeed()
        dataSource.fetchFeed(userAuth.uuid, object : RequestCallback<List<Post>>{
            override fun onSuccess(data: List<Post>) {
                localDataSource.putFeed(data)
                callback.onSuccess(data)
            }

            override fun onFailure(message: String) {
                callback.onFailure(message)
            }

            override fun onComplete() {
                callback.onComplete()
            }
        })
    }

    fun clearCache() {
        val localDataSource = dataSourceFactory.createLocalDataSource()
        localDataSource.putFeed(null)
    }

}