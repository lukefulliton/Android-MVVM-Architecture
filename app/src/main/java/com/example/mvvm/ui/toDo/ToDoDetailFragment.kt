package com.example.mvvm.ui.toDo

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentToDoDetailsBinding
import com.example.mvvm.global.base.BaseFragment
import com.example.mvvm.global.interfaces.callbacks.SpinnerCallback
import com.example.mvvm.ui.toDo.viewModel.ToDoDetailsViewModel

class ToDoDetailFragment : BaseFragment<ToDoDetailsViewModel>() {
    override lateinit var viewModel: ToDoDetailsViewModel
    private lateinit var fragmentToDoDetailsBinding: FragmentToDoDetailsBinding
    private val arguments: ToDoDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ToDoDetailsViewModel::class.java)
        fragmentToDoDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_details, container, false)

        //ToDo: Must do this for the Two-Way Databinding to work.
        fragmentToDoDetailsBinding.lifecycleOwner = this

        return fragmentToDoDetailsBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentToDoDetailsBinding.viewModel = viewModel
        fragmentToDoDetailsBinding.spinnerCallback = exampleCallback
        initSpinner()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getToDoItemById(arguments.toDoItemId)
    }

    private fun initSpinner() {
        viewModel.prioritiesOptions = resources.getStringArray(R.array.to_do_priorities).toMutableList()
        viewModel.spinnerPriorityAdapter = ArrayAdapter(requireContext(), R.layout.view_text_spinner, viewModel.prioritiesOptions)
    }

    private val exampleCallback = object : SpinnerCallback {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            viewModel.setPriority(position)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
            return false
        }
    }
}