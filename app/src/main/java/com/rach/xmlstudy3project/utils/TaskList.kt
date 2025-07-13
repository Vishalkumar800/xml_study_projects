package com.rach.xmlstudy3project.utils

import com.rach.xmlstudy3project.models.Task

object TaskList {
    fun taskList(): List<Task> {
        val task = listOf(
            Task("Take a break ", timeStamp = "7:00 am"),
            Task("Take a Lunch ", timeStamp = "7:10 am"),
            Task("Take a Bath", timeStamp = "8:00 am"),
            Task("Read a Book", timeStamp = "9:00 am"),
            Task("Buy Groceries", timeStamp = "10:00 am"),
            Task("Go To Bed", timeStamp = "9:00 pm"),
            Task("Take a break ", timeStamp = "7:00 am"),
            Task("Take a Lunch ", timeStamp = "7:10 am"),
            Task("Take a Bath", timeStamp = "8:00 am"),
            Task("Read a Book", timeStamp = "9:00 am"),
            Task("Buy Groceries", timeStamp = "10:00 am"),
            Task("Go To Bed", timeStamp = "9:00 pm")
        )

        return task
    }
}