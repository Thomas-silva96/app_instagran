package co.tsdroiddeveloper.course.instagram.search.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class SearchRepository(private val dataSource: SearchDataSource) {

    fun fetchUser(name: String, callback: RequestCallback<List<UserAuth>>) {
        dataSource.fetchUsers(name, object : RequestCallback<List<UserAuth>>{
            override fun onSuccess(data: List<UserAuth>) {
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

}
