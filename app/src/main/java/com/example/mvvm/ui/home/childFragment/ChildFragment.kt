package com.example.mvvm.ui.home.childFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentHomeChildBinding
import com.example.mvvm.global.base.BaseFragment
import com.example.mvvm.ui.home.childFragment.viewModel.ChildFragmentViewModel
import com.example.mvvm.ui.home.viewModel.HomeViewModel

class ChildFragment : BaseFragment<ChildFragmentViewModel>() {
    override lateinit var viewModel: ChildFragmentViewModel
    private lateinit var activityViewModel: HomeViewModel
    private lateinit var fragmentHomeChildBinding: FragmentHomeChildBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ChildFragmentViewModel::class.java)

        //Note: You can do this if you need to share data between fragments.
        activityViewModel = requireActivity().run {
            ViewModelProvider(this)[HomeViewModel::class.java]
        }

        fragmentHomeChildBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_child, container, false)

        return fragmentHomeChildBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentHomeChildBinding.viewModel = viewModel
    }
}