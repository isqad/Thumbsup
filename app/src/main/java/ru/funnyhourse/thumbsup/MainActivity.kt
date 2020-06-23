package ru.funnyhourse.thumbsup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.funnyhourse.thumbsup.databinding.ActivityMainBinding
import ru.funnyhourse.thumbsup.ui.fragments.ChatsFragment
import ru.funnyhourse.thumbsup.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar

    private lateinit var appDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        initFields()
        initFunc()
    }

    private fun initFields() {
        toolbar = binding.mainToolbar

        appDrawer = AppDrawer(this, toolbar)
    }

    private fun initFunc() {
        setSupportActionBar(toolbar)
        appDrawer.create()

        supportFragmentManager.beginTransaction().
            replace(R.id.data_container,
                ChatsFragment()
            ).
            commit()
    }
}
