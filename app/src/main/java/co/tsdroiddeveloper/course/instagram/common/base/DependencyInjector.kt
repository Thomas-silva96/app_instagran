package co.tsdroiddeveloper.course.instagram.common.base

import co.tsdroiddeveloper.course.instagram.add.data.AddFakeRemoteDataSource
import co.tsdroiddeveloper.course.instagram.add.data.AddLocalDataSource
import co.tsdroiddeveloper.course.instagram.add.data.AddRepository
import co.tsdroiddeveloper.course.instagram.home.data.FeedMemoryCache
import co.tsdroiddeveloper.course.instagram.home.data.HomeDataSourceFactory
import co.tsdroiddeveloper.course.instagram.home.data.HomeRepository
import co.tsdroiddeveloper.course.instagram.login.data.FakeDataSource
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository
import co.tsdroiddeveloper.course.instagram.profile.data.PostListMemoryCache
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileDataSourceFactory
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileMemoryCache
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
        return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
    }

    fun homeRepository(): HomeRepository {
        return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
    }

    fun addRepository(): AddRepository {
        return AddRepository(AddFakeRemoteDataSource(), AddLocalDataSource())
    }
}