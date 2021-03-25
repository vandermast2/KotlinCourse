package com.samapps.kotlincourse.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.samapps.kotlincourse.R
import com.samapps.kotlincourse.extentions.addFragmentSafelfy
import com.samapps.kotlincourse.extentions.onClick
import com.samapps.kotlincourse.extentions.replaceFragmentSafely
import com.samapps.kotlincourse.extentions.toast
import com.samapps.kotlincourse.models.UserModel
import com.samapps.kotlincourse.ui.fragments.main.MainFragment

class MainActivity : AppCompatActivity() {
    val mainContainer:FrameLayout by lazy { findViewById(R.id.mainContainer) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentSafelfy(fragment = MainFragment(),containerViewId = mainContainer.id)

    }
}