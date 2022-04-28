package co.tsdroiddeveloper.course.instagram.login.presentation

import android.util.Patterns
import co.tsdroiddeveloper.course.instagram.R
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth
import co.tsdroiddeveloper.course.instagram.login.Login
import co.tsdroiddeveloper.course.instagram.login.data.LoginCallback
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository

class LoginPresenter(
    private var view: Login.View?,
    private val repository: LoginRepository
) : Login.Presenter {

    override fun login(email: String, password: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }
        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.invalid_password)
        } else {
            view?.displayPasswordFailure(null)
        }

        if (isEmailValid && isPasswordValid) {
            view?.showProgress(true)

            repository.login(email, password, object : LoginCallback{
                override fun onSuccess(userAuth: UserAuth) {
                    view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnauthorized(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}