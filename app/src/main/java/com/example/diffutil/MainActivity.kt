package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val dataSet = arrayListOf<Student>().apply {
        add(Student("김현승", School.High, 2, listOf(100, 100, 100)))
        add(Student("김초딩", School.Elementary, 6, listOf(10, 30, 75)))
        add(Student("김중딩", School.Middle, 3, listOf(99, 97, 45)))
        add(Student("김대딩", School.University, 2, listOf(100, 100, 100)))
        add(Student("김현승", School.High, 2, listOf(100, 100, 100)))
        add(Student("김현승", School.High, 2, listOf(100, 100, 100)))
    }

    private val myRecyclerViewAdapter: MyRecyclerViewAdapter by lazy {
        MyRecyclerViewAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = myRecyclerViewAdapter
        }
        myRecyclerViewAdapter.submitList(dataSet)

        val itemTouchHelperCallback = ItemTouchHelper(MyItemTouchHelperCallback(binding.rvList))
        itemTouchHelperCallback.attachToRecyclerView(binding.rvList)

        binding.btnFab.setOnClickListener {
            myRecyclerViewAdapter.submitList(dataSet.shuffled())
        }
    }
}