package co.tsdroiddeveloper.course.instagram.profile.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface ProfileDataSource {

    fun fetchUserProfile(userUUID: String, callback: RequestCallback<Pair<UserAuth, Boolean?>>)

    fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>)

    fun followUser(userUUID: String, isFollow: Boolean, callback: RequestCallback<Boolean>) {
        throw java.lang.UnsupportedOperationException()
    }

    fun fetchSession(): UserAuth {
        throw UnsupportedOperationException()
    }

    fun putUser(response: Pair<UserAuth, Boolean?>) {
        throw UnsupportedOperationException()
    }

    fun putPosts(response: List<Post>?) {
        throw UnsupportedOperationException()
    }
}