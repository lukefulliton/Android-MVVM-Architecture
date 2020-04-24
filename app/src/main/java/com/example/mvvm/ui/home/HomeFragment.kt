package com.example.mvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentHomeBinding
import com.example.mvvm.global.base.BaseFragment
import com.example.mvvm.ui.home.childFragment.ChildFragment
import com.example.mvvm.ui.home.viewModel.HomeViewModel

class HomeFragment : BaseFragment<HomeViewModel>() {
    override lateinit var viewModel: HomeViewModel
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val textView: TextView = fragmentHomeBinding.root.findViewById(R.id.text_home)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        this.childFragmentManager
            .beginTransaction()
            .add(R.id.home_child_fragment, ChildFragment())
            .commit()

        return fragmentHomeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentHomeBinding.viewModel = viewModel
    }
}
