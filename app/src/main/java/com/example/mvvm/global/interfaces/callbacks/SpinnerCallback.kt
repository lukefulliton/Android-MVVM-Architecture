package com.example.mvvm.global.interfaces.callbacks

import android.widget.AdapterView
import android.widget.TextView

interface SpinnerCallback : TextView.OnEditorActionListener, AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?)
}