package com.example.mvvm.ui.toDo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentToDoListBinding
import com.example.mvvm.global.base.BaseFragment
import com.example.mvvm.ui.toDo.viewModel.ToDoListViewModel

class ToDoListFragment : BaseFragment<ToDoListViewModel>() {
    override lateinit var viewModel: ToDoListViewModel
    private lateinit var fragmentToDoListBinding: FragmentToDoListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ToDoListViewModel::class.java)
        fragmentToDoListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_list, container, false)

        //ToDo: Must do this for the Two-Way Databinding to work.
        fragmentToDoListBinding.lifecycleOwner = this

        return fragmentToDoListBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentToDoListBinding.viewModel = viewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.getToDoItems()
    }
}