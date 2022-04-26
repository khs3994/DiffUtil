package com.example.diffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiffCallback : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean { // 두 객체를 비교
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean { // 내용이 같은지 비교
        return oldItem == newItem
    }
}