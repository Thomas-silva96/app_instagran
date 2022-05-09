package co.tsdroiddeveloper.course.instagram.profile.view

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import co.tsdroiddeveloper.course.instagram.R
import co.tsdroiddeveloper.course.instagram.common.base.BaseFragment
import co.tsdroiddeveloper.course.instagram.common.base.DependencyInjector
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth
import co.tsdroiddeveloper.course.instagram.databinding.FragmentProfileBinding
import co.tsdroiddeveloper.course.instagram.profile.Profile
import co.tsdroiddeveloper.course.instagram.profile.presentation.ProfilePresenter

class ProfileFragment
    : BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
), Profile.View {

    override lateinit var presenter: Profile.Presenter

    private val adapter = PostAdapter()

    override fun setupPresenter() {
        val repository = DependencyInjector.profileRepository()
        presenter = ProfilePresenter(this, repository)
    }

    override fun setupView() {
        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = adapter

        presenter.fetchUserProfile()
    }

    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtPostsCount?.text = userAuth.postCount.toString()
        binding?.profileTxtFollowerCount?.text = userAuth.followersCount.toString()
        binding?.profileTxtFollowingCount?.text = userAuth.followingCount.toString()
        binding?.profileTxtUsername?.text = userAuth.name
        binding?.profileTxtBio?.text = "Todo"
        binding?.profileImgIcon?.setImageURI(userAuth.photoUri)
        presenter.fetchUserPost()
    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun displayEmptyPosts() {
        binding?.profileTxtEmpty?.visibility = View.VISIBLE
        binding?.profileRv?.visibility = View.GONE
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun displayFullPosts(posts: List<Post>) {
        binding?.profileTxtEmpty?.visibility = View.GONE
        binding?.profileRv?.visibility = View.VISIBLE
        adapter.items = posts
        adapter.notifyDataSetChanged()
    }

    override fun getMenu() = R.menu.menu_profile

}