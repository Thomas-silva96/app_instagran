package co.tsdroiddeveloper.course.instagram.post

import android.net.Uri
import co.tsdroiddeveloper.course.instagram.common.base.BasePresenter
import co.tsdroiddeveloper.course.instagram.common.base.BaseView

interface Post {

    interface Presenter: BasePresenter {
        fun selectUri(uri: Uri)
        fun getSelectUri(): Uri?
        fun fetchPicture()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayFullPictures(posts: List<Uri>)
        fun displayEmptyPictures()
        fun displayRequestFailure(message: String)
    }
}