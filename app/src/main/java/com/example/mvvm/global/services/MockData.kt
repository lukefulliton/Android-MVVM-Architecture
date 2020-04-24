package com.example.mvvm.global.services

import com.example.mvvm.global.model.ToDo

object MockData {
    var toDos = ArrayList<ToDo>()

    init {
        initializeToDoList()
    }

    fun getByToDoById(toDoId: Int): ToDo {
        return toDos.firstOrNull { toDo -> toDo.toDoItemId == toDoId } ?: ToDo()
    }

    private fun initializeToDoList() {
        toDos.add(ToDo(1, "Item One", "Description One", false))
        toDos.add(ToDo(2, "Item Two", "Description Two", false))
        toDos.add(ToDo(3, "Item Three", "Description Three", false))
        toDos.add(ToDo(4, "Item Four", "Description Four", false))
        toDos.add(ToDo(5, "Item Five", "Description Five", true))
        toDos.add(ToDo(6, "Item Six", "Description Six", false))
        toDos.add(ToDo(7, "Item Seven", "Description Seven", false))
        toDos.add(ToDo(8, "Item Eight", "Description Eight", true))
        toDos.add(ToDo(9, "Item Nine", "Description Nine", false))
        toDos.add(ToDo(10, "Item Ten", "Description Ten", false))
    }
}