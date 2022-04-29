package co.tsdroiddeveloper.course.instagram.splash.data

import co.tsdroiddeveloper.course.instagram.common.model.DataBase

class FakeLocalDataSource : SplashDataSource {
    override fun session(callback: SplashCallback) {
        if (DataBase.sessionAuth != null) {
            callback.onSuccess()
        } else {
            callback.onFailure()
        }
    }

}