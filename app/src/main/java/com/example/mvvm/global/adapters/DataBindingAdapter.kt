package com.example.mvvm.global.adapters

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object DataBindingAdapter {

    @BindingAdapter("bindAdapter")
    @JvmStatic
    fun bindAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    @BindingAdapter("bindAdapter")
    @JvmStatic
    fun bindAdapter(appCompatSpinner: AppCompatSpinner, arrayAdapter: ArrayAdapter<String>) {
        appCompatSpinner.adapter = arrayAdapter
    }

    @BindingAdapter("onItemSelected")
    @JvmStatic
    fun setItemSelectedListener(appCompatSpinner: AppCompatSpinner, itemSelectedListener: AdapterView.OnItemSelectedListener?) {
        appCompatSpinner.onItemSelectedListener = itemSelectedListener
    }

    @BindingAdapter("bindAdapter")
    @JvmStatic
    fun bindAdapter(spinner: Spinner, arrayAdapter: ArrayAdapter<String>) {
        spinner.adapter = arrayAdapter
    }

    @BindingAdapter("onItemSelected")
    @JvmStatic
    fun setItemSelectedListener(spinner: Spinner, itemSelectedListener: AdapterView.OnItemSelectedListener?) {
        spinner.onItemSelectedListener = itemSelectedListener
    }

    @BindingAdapter("bindBackgroundResource")
    @JvmStatic
    fun bindBackgroundResource(imgView: ImageView, resourceId: Int) {
        imgView.setBackgroundResource(resourceId)
    }

    @BindingAdapter("bindSpinnerSetSelection")
    @JvmStatic
    fun bindSpinnerSetSelection(spinner: Spinner, position: Int = 0) {
        spinner.setSelection(position)
    }

    @BindingAdapter("bindVisibility")
    @JvmStatic
    fun bindVisibility(view: View, isVisible: Boolean) {
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @BindingAdapter("bindAssetImage", "defaultImageResDrawable")
    @JvmStatic
    fun bindAssetImage(imgView: ImageView, image: String?, defaultImageResDrawable: Int) {
//        Glide.with(imgView)
//            .load(image)
//            .centerCrop()
//            .placeholder(defaultImageResDrawable)
//            .error(defaultImageResDrawable)
//            .fallback(defaultImageResDrawable)
//            .into(imgView)
//
//        //This image value maybe a base64 value.
//        val imageByteArray: ByteArray =  Base64.decode(image ?: "", Base64.DEFAULT)
//
//        Glide.with(imgView)
//            .asBitmap()
//            .load(imageByteArray)
//            .centerCrop()
//            .placeholder(defaultImageResDrawable)
//            .error(defaultImageResDrawable)
//            .fallback(defaultImageResDrawable)
//            .into(imgView)
    }

}