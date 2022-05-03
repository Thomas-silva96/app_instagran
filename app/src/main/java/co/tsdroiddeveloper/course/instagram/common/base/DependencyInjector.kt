package co.tsdroiddeveloper.course.instagram.common.base

import co.tsdroiddeveloper.course.instagram.login.data.FakeDataSource
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileFakeRemoteDataSource
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileRepository
import co.tsdroiddeveloper.course.instagram.register.data.FakeRegisterDataSource
import co.tsdroiddeveloper.course.instagram.register.data.RegisterRepository
import co.tsdroiddeveloper.course.instagram.splash.data.FakeLocalDataSource
import co.tsdroiddeveloper.course.instagram.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository(): SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

    fun profileRepository(): ProfileRepository {
        return ProfileRepository(ProfileFakeRemoteDataSource())
    }
}