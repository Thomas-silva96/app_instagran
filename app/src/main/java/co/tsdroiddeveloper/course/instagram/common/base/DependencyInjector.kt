package co.tsdroiddeveloper.course.instagram.common.base

import co.tsdroiddeveloper.course.instagram.login.data.FakeDataSource
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository
import co.tsdroiddeveloper.course.instagram.register.data.FakeRegisterDataSource
import co.tsdroiddeveloper.course.instagram.register.data.RegisterRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }
}