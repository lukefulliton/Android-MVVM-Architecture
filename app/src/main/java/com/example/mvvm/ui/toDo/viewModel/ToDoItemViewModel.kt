package com.example.mvvm.ui.toDo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.global.base.BaseViewModel
import com.example.mvvm.global.model.ToDo

class ToDoItemViewModel(_item: ToDo) : BaseViewModel() {
    private var mObservableItem = MutableLiveData<ToDo>(_item)

    // ToDo: Note: Omitting these getters and setters is ideal.
    // However, if interception of the get or set action is needed, this is how it is done.
    fun getItem(): LiveData<ToDo> {
        return mObservableItem
    }

    fun setItem(value: ToDo) {
        mObservableItem.value = value
    }

    fun getIsComplete(): Boolean {
        return getItem().value?.isComplete ?: false
    }

    fun setIsComplete(value: Boolean) {
        //ToDo: You could put a network API call here.
        getItem().value?.isComplete = value
    }
}