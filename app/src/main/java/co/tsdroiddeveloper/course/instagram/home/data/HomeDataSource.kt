package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post

interface HomeDataSource {

    fun logout() {
        throw UnsupportedOperationException()
    }

    fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession(): String {
        throw UnsupportedOperationException()
    }

    fun putFeed(response: List<Post>?) {
        throw UnsupportedOperationException()
    }
}