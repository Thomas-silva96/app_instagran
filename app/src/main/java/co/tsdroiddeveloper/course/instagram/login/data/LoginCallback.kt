package co.tsdroiddeveloper.course.instagram.login.data

import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface LoginCallback {
    fun onSuccess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}
