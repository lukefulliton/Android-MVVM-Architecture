package com.example.mvvm.ui.home.childFragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.global.base.BaseViewModel
import com.example.mvvm.global.model.Ping

class ChildFragmentViewModel : BaseViewModel() {
    private var mObservableText = MutableLiveData<Ping>()

    init {
        setPing(Ping("Home", "Child Fragment Example"))
    }

    fun getPing(): LiveData<Ping> {
        return mObservableText
    }

    fun setPing(value: Ping) {
        mObservableText.value = value
    }

}