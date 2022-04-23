package com.example.diffutil

data class Student(
    val name: String,
    val school: School,
    val grade: Int,
    val stats: List<Int>,
)

enum class School {
    Elementary, Middle, High, University
}