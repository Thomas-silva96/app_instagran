package co.tsdroiddeveloper.course.instagram.common.base

import android.content.Context
import co.tsdroiddeveloper.course.instagram.add.data.AddLocalDataSource
import co.tsdroiddeveloper.course.instagram.add.data.AddRepository
import co.tsdroiddeveloper.course.instagram.add.data.FireAddDataSource
import co.tsdroiddeveloper.course.instagram.home.data.FeedMemoryCache
import co.tsdroiddeveloper.course.instagram.home.data.HomeDataSourceFactory
import co.tsdroiddeveloper.course.instagram.home.data.HomeRepository
import co.tsdroiddeveloper.course.instagram.login.data.FireLoginDataSource
import co.tsdroiddeveloper.course.instagram.login.data.LoginRepository
import co.tsdroiddeveloper.course.instagram.post.data.PostLocalDataSource
import co.tsdroiddeveloper.course.instagram.post.data.PostRepository
import co.tsdroiddeveloper.course.instagram.profile.data.PostListMemoryCache
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileDataSourceFactory
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileMemoryCache
import co.tsdroiddeveloper.course.instagram.profile.data.ProfileRepository
import co.tsdroiddeveloper.course.instagram.register.data.FireRegisterDataSource
import co.tsdroiddeveloper.course.instagram.register.data.RegisterRepository
import co.tsdroiddeveloper.course.instagram.search.data.FireSearchDataSource
import co.tsdroiddeveloper.course.instagram.search.data.SearchRepository
import co.tsdroiddeveloper.course.instagram.splash.data.FireSplashDataSource
import co.tsdroiddeveloper.course.instagram.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository(): SplashRepository {
        return SplashRepository(FireSplashDataSource())
    }

    fun loginRepository(): LoginRepository {
        return LoginRepository(FireLoginDataSource())
    }

    fun registerEmailRepository(): RegisterRepository {
        return RegisterRepository(FireRegisterDataSource())
    }

    fun searchRepository() : SearchRepository {
        return SearchRepository(FireSearchDataSource())
    }

    fun profileRepository(): ProfileRepository {
        return ProfileRepository(ProfileDataSourceFactory(ProfileMemoryCache, PostListMemoryCache))
    }

    fun homeRepository(): HomeRepository {
        return HomeRepository(HomeDataSourceFactory(FeedMemoryCache))
    }

    fun addRepository(): AddRepository {
        return AddRepository(FireAddDataSource(), AddLocalDataSource())
    }

    fun postRepository(context: Context): PostRepository {
        return PostRepository(PostLocalDataSource(context))
    }
}