package co.tsdroiddeveloper.course.instagram.home.data

import co.tsdroiddeveloper.course.instagram.common.base.Cache
import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.DataBase
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class HomeLocalDataSource(
    private val feedCache: Cache<List<Post>>
) : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = feedCache.get(userUUID)
        if (posts != null) {
            callback.onSuccess(posts)
        } else {
            callback.onFailure("Posts não existem")
        }
        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return DataBase.sessionAuth ?: throw RuntimeException("Usuário não logado!!!")
    }

    override fun putFeed(response: List<Post>?) {
        feedCache.put(response)
    }
}
