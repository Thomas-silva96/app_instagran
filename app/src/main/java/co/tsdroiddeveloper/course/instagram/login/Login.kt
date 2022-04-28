package co.tsdroiddeveloper.course.instagram.login

import androidx.annotation.StringRes
import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String, password: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun displayPasswordFailure(@StringRes passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}