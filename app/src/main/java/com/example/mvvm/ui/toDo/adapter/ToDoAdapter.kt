package com.example.mvvm.ui.toDo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ViewToDoItemBinding
import com.example.mvvm.global.interfaces.callbacks.NavCallback
import com.example.mvvm.global.model.ToDo
import com.example.mvvm.ui.toDo.viewModel.ToDoItemViewModel

class ToDoAdapter(private val navCallback: NavCallback<ToDo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val items = mutableListOf<ToDo>()

    inner class RecyclerHolder(private var viewBinding: ViewToDoItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(toDoItem: ToDo) {
            viewBinding.viewModel = ToDoItemViewModel(toDoItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = ViewToDoItemBinding.inflate(layoutInflater, parent, false)

        // ToDo: Note: In the single activity architecture,
        //  the fragment containing the adapter should handle ALL the navigation logic.
        viewBinding.navigationCallback = navCallback

        return RecyclerHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecyclerHolder).bind(items[position])
    }

    override fun getItemCount() = items.size

    fun add(toDoItem: ToDo) {
        if (items.add(toDoItem)) {
            notifyItemInserted(items.size - 1)
        }
    }

    fun addAll(toDoItems: MutableList<ToDo>){
        if (items.addAll(items.size, toDoItems)) {
            notifyItemRangeInserted(items.size - toDoItems.size, toDoItems.size)
        }
    }

    fun setAll(toDoItems: MutableList<ToDo>){
        items.clear()
        if (items.addAll(toDoItems)) {
            notifyDataSetChanged()
        }
    }

    fun clear(){
        items.clear()
    }
}