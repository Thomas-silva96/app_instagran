package co.tsdroiddeveloper.course.instagram.profile

import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth

interface Profile {

    interface Presenter : BasePresenter {
        fun fetchUserProfile()
        fun fetchUserPost()
        fun clear()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayUserProfile(userAuth: UserAuth)
        fun displayRequestFailure(message: String)
        fun displayEmptyPosts()
        fun displayFullPosts(posts: List<Post>)
    }
}