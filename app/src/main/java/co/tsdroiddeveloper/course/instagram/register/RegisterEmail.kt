package co.tsdroiddeveloper.course.instagram.register

import androidx.annotation.StringRes
import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView

interface RegisterEmail {

    interface Presenter : BasePresenter {
        fun create(email: String)
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(@StringRes emailError: Int?)
        fun onEmailFailure(message: String)
        fun goToNameAndPasswordScree(email: String)
    }
}