package com.example.mvvm.global.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mvvm.global.events.Event

abstract class BaseViewModel : ViewModel() {
    private val _nav = MutableLiveData<Event<NavDirections>>()
    val nav: LiveData<Event<NavDirections>> = _nav

    fun navigate(navigationDirections: NavDirections) {
        _nav.value = Event(navigationDirections)
    }

    fun someOtherBaseFunction() {

    }
}