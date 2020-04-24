package com.example.mvvm.global.model

data class ToDo(val toDoItemId: Int = -1,
                var title: String = "ToDo Item",
                var description: String = "Some Task To Complete",
                var isComplete: Boolean = false,
                var priority: String = "Low Priority") {
}