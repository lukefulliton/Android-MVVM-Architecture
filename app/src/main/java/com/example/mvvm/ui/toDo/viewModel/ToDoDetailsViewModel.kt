package com.example.mvvm.ui.toDo.viewModel

import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.global.base.BaseViewModel
import com.example.mvvm.global.model.ToDo
import com.example.mvvm.global.networker.ExampleNetworker
import com.example.mvvm.global.services.MockData
import kotlinx.coroutines.*

class ToDoDetailsViewModel : BaseViewModel() {
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    var toDo = MutableLiveData<ToDo>()
    var priorityPosition = MutableLiveData(0)
    lateinit var spinnerPriorityAdapter: ArrayAdapter<String>
    lateinit var prioritiesOptions: MutableList<String>

    fun getToDoItemById(toDoId: Int) {
        uiScope.launch {
            //Thread.sleep(500)
            val to_Do = MockData.getByToDoById(toDoId)

            //ToDo: Here is an example of a network API call.
//            val defResponse = async { ExampleNetworker.getPingAsync() }
//            val toDoResponse = defResponse.await()

            //if (toDoResponse.isSuccessful) {
                toDo.value = to_Do
                setPriority()
            //}
        }
    }

    fun setPriority(index: Int) {
        val to_Do = toDo.value

        if (to_Do != null && to_Do.priority != prioritiesOptions[index]) {
            //ToDo: You could put a network API call here.
            to_Do.priority = prioritiesOptions[index]
            val toDoFromMockData = MockData.getByToDoById(to_Do.toDoItemId)
            toDoFromMockData.priority = to_Do.priority
        }
    }

    private fun setPriority() {
        val priority = prioritiesOptions.firstOrNull { it == toDo.value?.priority } ?: prioritiesOptions[0]
        priorityPosition.value = prioritiesOptions.indexOf(priority)
        //spinnerPriorityAdapter.notifyDataSetChanged()
    }

}