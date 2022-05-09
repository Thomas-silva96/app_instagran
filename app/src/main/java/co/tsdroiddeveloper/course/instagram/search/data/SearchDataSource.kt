package co.tsdroiddeveloper.course.instagram.search.data

import co.tsdroiddeveloper.course.instagram.common.base.RequestCallback
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface SearchDataSource {
    fun fetchUsers(name: String, callback: RequestCallback<List<UserAuth>>)
}