package co.tsdroiddeveloper.course.instagram.register.data

import android.os.Looper
import android.os.Handler
import co.tsdroiddeveloper.course.instagram.common.model.DataBase

class FakeRegisterEmailDataSource : RegisterEmailDataSource {
    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({

            val userAuth = DataBase.usersAuth.firstOrNull { email == it.email }

           if (userAuth == null) {
               callback.onSuccess()
           } else {
               callback.onFailure("Usuário já cadastrado")
           }
            callback.onComplete()
        }, 2000)
    }
}