package co.tsdroiddeveloper.course.instagram.profile.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>)

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

    fun fetchSession(): UserAuth {
        throw UnsupportedOperationException()
    }

    fun putUser(response: UserAuth) {
        throw UnsupportedOperationException()
    }

    fun putPosts(response: List<Post>?) {
        throw UnsupportedOperationException()
    }
}