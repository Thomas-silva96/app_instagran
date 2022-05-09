package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface HomeDataSource {

    fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession(): UserAuth {
        throw UnsupportedOperationException()
    }

    fun putFeed(response: List<Post>?) {
        throw UnsupportedOperationException()
    }
}