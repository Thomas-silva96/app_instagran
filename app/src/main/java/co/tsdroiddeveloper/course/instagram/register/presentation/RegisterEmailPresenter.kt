package co.tsdroiddeveloper.course.instagram.register.presentation

import android.util.Patterns
import co.tsdroiddeveloper.course.instagram.R
import co.tsdroiddeveloper.course.instagram.register.RegisterEmail
import co.tsdroiddeveloper.course.instagram.register.data.RegisterCallback
import co.tsdroiddeveloper.course.instagram.register.data.RegisterRepository

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterRepository
) : RegisterEmail.Presenter {

    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid) {
            view?.displayEmailFailure(R.string.invalid_email)
        } else {
            view?.displayEmailFailure(null)
        }

        if (isEmailValid) {
            view?.showProgress(true)

            repository.create(email, object : RegisterCallback{
                override fun onSuccess() {
                    view?.goToNameAndPasswordScree(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
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