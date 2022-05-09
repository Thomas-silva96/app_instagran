package co.tsdroiddeveloper.course.instagram.search.data

import android.os.Handler
import android.os.Looper
import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.DataBase
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class SearchFakeRemoteDataSource : SearchDataSource {

    override fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>) {
        Handler(Looper.getMainLooper()).postDelayed({

            val users = DataBase.usersAuth.filter {
                it.name.lowercase().startsWith(name) && it.uuid != DataBase.sessionAuth!!.uuid
            }
            callback.onSuccess(users.toList())
            callback.onComplete()
        }, 2000)
    }
}