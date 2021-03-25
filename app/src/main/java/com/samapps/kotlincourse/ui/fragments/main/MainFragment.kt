package com.samapps.kotlincourse.ui.fragments.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.lifecycle.lifecycleScope
import com.samapps.kotlincourse.R
import com.samapps.kotlincourse.extentions.onClick
import com.samapps.kotlincourse.extentions.textInputAsFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainFragment : Fragment() {
    lateinit var fragmentView: View
    val btnNext: Button by lazy { fragmentView.findViewById(R.id.btnNext) }
    val etUsername: EditText by lazy { fragmentView.findViewById(R.id.etUsername) }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentView = view
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setListeners()
    }

    private fun setListeners() {
        etUsername.textInputAsFlow()
                .debounce(500)
                .onEach {
                    setLoginError()
                }
                .launchIn(lifecycleScope)


    }

    private fun setLoginError(
            @StringRes errorRes: Int? = null
    ) {
        val isVisible = errorRes != null
        btnNext.isEnabled = !isVisible
    }
}




