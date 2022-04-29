package co.tsdroiddeveloper.course.instagram.splash

import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView

interface Splash {
    interface Presenter : BasePresenter {
        fun autenticated()
    }

    interface View : BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()
    }
}