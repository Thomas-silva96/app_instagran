package co.tsdroiddeveloper.course.instagram.profile.data

import co.tsdroiddeveloper.course.instagram.common.base.Cache
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class ProfileDataSourceFactory(
    private val profileCache: Cache<UserAuth>,
    private val postCache: Cache<List<Post>>
) {
    fun createLocalDataSource(): ProfileDataSource {
        return ProfileLocalDataSource(profileCache, postCache)
    }

    fun createFromUser(): ProfileDataSource {
        if (profileCache.isCached()) {
            return ProfileLocalDataSource(profileCache, postCache)
        }
        return ProfileFakeRemoteDataSource()
    }

    fun createFromPosts(): ProfileDataSource {
        if (postCache.isCached()) {
            return ProfileLocalDataSource(profileCache, postCache)
        }
        return ProfileFakeRemoteDataSource()
    }
}
