package co.tsdroiddeveloper.course.instagram.search

import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface Search {

    interface Presenter : BasePresenter {
        fun fetchUsers(name: String)
    }

    interface View: BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayFullUsers(users: List<UserAuth>)
        fun displauEmptyUsers()
    }

}