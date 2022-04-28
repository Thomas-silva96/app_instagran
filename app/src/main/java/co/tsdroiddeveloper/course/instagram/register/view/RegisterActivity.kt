package co.tsdroiddeveloper.course.instagram.register.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.tsdroiddeveloper.course.instagram.R
import co.tsdroiddeveloper.course.instagram.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.register_fragment, fragment)
            commit()
        }
    }
}