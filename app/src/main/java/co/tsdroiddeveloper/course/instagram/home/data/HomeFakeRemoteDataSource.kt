package co.tsdroiddeveloper.course.instagram.home.data

import android.os.Handler
import android.os.Looper
import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.DataBase
import co.tsdroiddeveloper.course.instagram.common.model.Post

class HomeFakeRemoteDataSource : HomeDataSource {

    override fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val feed = DataBase.feeds[userUUID]

            callback.onSuccess(feed?.toList() ?: emptyList())
            callback.onComplete()
        }, 2000)
    }
}