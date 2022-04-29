package co.tsdroiddeveloper.course.instagram.splash.presentation

import co.tsdroiddeveloper.course.instagram.splash.Splash
import co.tsdroiddeveloper.course.instagram.splash.data.SplashCallback
import co.tsdroiddeveloper.course.instagram.splash.data.SplashRepository

class SplashPresenter(
    private var view: Splash.View?,
    private val repository: SplashRepository
) : Splash.Presenter {

    override fun autenticated() {
        repository.session(object : SplashCallback {
            override fun onSuccess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }

        })
    }

    override fun onDestroy() {
        view = null
    }
}