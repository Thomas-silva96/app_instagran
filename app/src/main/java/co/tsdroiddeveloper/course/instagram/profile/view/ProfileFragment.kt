package co.tsdroiddeveloper.course.instagram.profile.view

import android.annotation.SuppressLint
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.tsdroiddeveloper.course.instagram.R
import co.tsdroiddeveloper.course.instagram.common.base.BaseFragment
import co.tsdroiddeveloper.course.instagram.common.base.DependencyInjector
import co.tsdroiddeveloper.course.instagram.common.model.Post
import co.tsdroiddeveloper.course.instagram.common.model.UserAuth
import co.tsdroiddeveloper.course.instagram.databinding.FragmentProfileBinding
import co.tsdroiddeveloper.course.instagram.profile.Profile
import co.tsdroiddeveloper.course.instagram.profile.presentation.ProfilePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment
    : BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
), Profile.View, BottomNavigationView.OnNavigationItemSelectedListener {

    override lateinit var presenter: Profile.Presenter

    private val adapter = PostAdapter()
    private var uuid: String? = null

    override fun setupPresenter() {
        val repository = DependencyInjector.profileRepository()
        presenter = ProfilePresenter(this, repository)
    }

    override fun setupView() {
        uuid = arguments?.getString(KEY_USER_ID)

        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = adapter
        binding?.profileNavTabs?.setOnNavigationItemSelectedListener(this)

        binding?.profileBtnEditProfile?.setOnClickListener {
            if (it.tag == true) {
                binding?.profileBtnEditProfile?.text = getString(R.string.follow)
                binding?.profileBtnEditProfile?.tag = false
                presenter.followUser(uuid, false)
            } else if (it.tag == false) {
                binding?.profileBtnEditProfile?.text = getString(R.string.unfollow)
                binding?.profileBtnEditProfile?.tag = true
                presenter.followUser(uuid, true)
            }
        }

        presenter.fetchUserProfile(uuid)
    }

    override fun showProgress(enabled: Boolean) {
        binding?.profileProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun displayUserProfile(userAuth: Pair<UserAuth, Boolean?>) {
        val (user, following) = userAuth

        binding?.profileTxtPostsCount?.text = user.postCount.toString()
        binding?.profileTxtFollowerCount?.text = user.followersCount.toString()
        binding?.profileTxtFollowingCount?.text = user.followingCount.toString()
        binding?.profileTxtUsername?.text = user.name
        binding?.profileTxtBio?.text = "Todo"
        binding?.profileImgIcon?.setImageURI(user.photoUri)

        binding?.profileBtnEditProfile?.text = when (following) {
            null -> getString(R.string.edit_profile)
            true -> getString(R.string.unfollow)
            false -> getString(R.string.follow)
        }

        binding?.profileBtnEditProfile?.tag = following
        presenter.fetchUserPost(uuid)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profile_grid -> {
                binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
            }
            R.id.menu_profile_list -> {
                binding?.profileRv?.layoutManager = LinearLayoutManager(requireContext())
            }
        }
        return true
    }

    companion object {
        const val KEY_USER_ID = "key_user_id"
    }

}