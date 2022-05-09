package co.tsdroiddeveloper.course.instagram.profile.data

import android.os.Handler
import android.os.Looper
import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.DataBase
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class ProfileFakeRemoteDataSource : ProfileDataSource {
    override fun fetchUserProfile(
        userUUID: String,
        callback: RequestCallback<Pair<UserAuth, Boolean?>>
    ) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { userUUID == it.uuid }

            if (userAuth != null) {
                if (userAuth == DataBase.sessionAuth) {
                    callback.onSuccess(Pair(userAuth, null))
                } else {
                    val followings = DataBase.followers[DataBase.sessionAuth!!.uuid]

                    val destUser = followings?.firstOrNull { it == userUUID }

                    callback.onSuccess(Pair(userAuth, destUser != null))
                }
            } else {
                callback.onFailure("Usuário não encontrado")
            }
            callback.onComplete()
        }, 2000)
    }

    override fun fetchUserPosts(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val posts = DataBase.posts[userUUID]

            callback.onSuccess(posts?.toList() ?: emptyList())
            callback.onComplete()
        }, 2000)
    }

    override fun followUser(
        userUUID: String,
        isFollow: Boolean,
        callback: RequestCallback<Boolean>
    ) {
        Handler(Looper.getMainLooper()).postDelayed({

            var followers = DataBase.followers[DataBase.sessionAuth!!.uuid]

            if (followers == null) {
                followers = mutableSetOf()
                DataBase.followers[DataBase.sessionAuth!!.uuid] = followers
            }

            if (isFollow) {
                DataBase.followers[DataBase.sessionAuth!!.uuid]!!.add(userUUID)
            } else {
                DataBase.followers[DataBase.sessionAuth!!.uuid]!!.remove(userUUID)
            }
            callback.onSuccess(true)
            callback.onComplete()
        }, 500)
    }
}