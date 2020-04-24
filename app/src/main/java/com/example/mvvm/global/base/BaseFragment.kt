package com.example.mvvm.global.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mvvm.global.events.EventObserver

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {
    private lateinit var navigationController: NavController
    protected abstract var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(view)
        setupNavObserver()
    }

    private fun setupNavObserver() {
        viewModel.nav.observe(requireActivity(), EventObserver {
            navigationController.navigate(it)
        })
    }

    fun someOtherBaseFragmentMethodHere() {
        //ToDo: You could implement something else here.
    }
}