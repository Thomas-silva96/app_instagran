package co.tsdroiddeveloper.course.instagram.profile.data

import co.tsdroiddeveloper.course.instagram.common.base.Cache
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

class ProfileDataSourceFactory(
    private val profileCache: Cache<Pair<UserAuth, Boolean?>>,
    private val postCache: Cache<List<Post>>
) {
    fun createLocalDataSource(): ProfileDataSource {
        return ProfileLocalDataSource(profileCache, postCache)
    }

    fun createFromUser(uuid: String?): ProfileDataSource {
        if (uuid != null)
            return ProfileFakeRemoteDataSource()

        if (profileCache.isCached()) {
            return ProfileLocalDataSource(profileCache, postCache)
        }
        return ProfileFakeRemoteDataSource()
    }

    fun createFromPosts(uuid: String?): ProfileDataSource {
        if (uuid != null)
            return ProfileFakeRemoteDataSource()

        if (postCache.isCached()) {
            return ProfileLocalDataSource(profileCache, postCache)
        }
        return ProfileFakeRemoteDataSource()
    }

    fun creatRemoteDataSource(): ProfileDataSource {
        return ProfileFakeRemoteDataSource()

    }
}
