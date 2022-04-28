package co.tsdroiddeveloper.course.instagram.common.base

import co.tsdroiddeveloper.course.instagram.login.data.FakeDataSource
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository
import co.tsdroiddeveloper.course.instagram.register.data.FakeRegisterEmailDataSource
import co.tsdroiddeveloper.course.instagram.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterEmailRepository {
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }
}