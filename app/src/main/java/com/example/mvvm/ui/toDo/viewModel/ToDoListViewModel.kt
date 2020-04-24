package com.example.mvvm.ui.toDo.viewModel

import com.example.mvvm.global.base.BaseViewModel
import com.example.mvvm.global.interfaces.callbacks.NavCallback
import com.example.mvvm.global.model.ToDo
import com.example.mvvm.global.networker.ExampleNetworker
import com.example.mvvm.global.services.MockData
import com.example.mvvm.ui.toDo.ToDoListFragmentDirections
import com.example.mvvm.ui.toDo.adapter.ToDoAdapter
import kotlinx.coroutines.*

class ToDoListViewModel : BaseViewModel() {
    val adapter by lazy { ToDoAdapter(navCallback) }
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getToDoItems() {
        uiScope.launch {
            //ToDo: Note, here is an example of a async network call.
            // It is commented out because it is NOT talking to a real API.
//            val defResponse = async { ExampleNetworker.getPingExample2Async() }
//            val toDoResponse = defResponse.await()
//
//            if (toDoResponse.isSuccessful) {
                setAllInAdapter(MockData.toDos)
//            }
        }
    }

    private fun addInAdapter(toDo: ToDo) {
        adapter.add(toDo)
    }

    private fun addAllInAdapter(toDos: MutableList<ToDo>) {
        adapter.addAll(toDos)
    }

    private fun setAllInAdapter(toDos: MutableList<ToDo>) {
        adapter.setAll(toDos)
    }

    val navCallback = object : NavCallback<ToDo> {
        override fun nav(customModel: ToDo) {
            val directions = ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment(customModel.toDoItemId)
            navigate(directions)
        }

        override fun nav() {
            val directions = ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment()
            navigate(directions)
        }
    }
}