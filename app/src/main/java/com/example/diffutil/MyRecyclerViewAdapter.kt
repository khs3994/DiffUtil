package com.example.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.LayoutViewholderBinding
import java.text.FieldPosition
import java.util.*

class MyRecyclerViewAdapter : ListAdapter<Student, RecyclerView.ViewHolder>(MyDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(
            LayoutViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { //포지션을 전달받아서 해당되는 데이터와 뷰홀더를 묶어준다
        if (holder is MyViewHolder) {
            val student = getItem(position) as Student
            holder.bind(student) // 뷰홀더의 bind 함수가 실행되면서 데이터와 텍스트 뷰의 내용이 결합된다
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int) { // 아이템 이동함수
        //변경하기 전 위치와 변경한 후의 위치를 받아온다
        // 그 위치를 반영한 새로운 데이터를 만들어낸다
        // 그 새로운 데이터를 기존의 데이터와 비교한다
        // 포지션이 변경된 데이터를 submitList에 넣어준다
        val newList = currentList.toMutableList() // ListAdapter를 상속받을시에는 currentList를 통해서 새로운 데이터를 만들어 낼수 있다
                                                 // 하지만 이 데이터는 변경이 불가능한 상태이기 때문에 toMutableList()를 통해 변경이 가능한 상태로 만들어 준다다
        Collections.swap(newList, fromPosition, toPosition) // 이 swap 함수를 통해 newList를 위치가 바뀐 아이템으로 newList를 바꿔준다
        submitList(newList)
    }

    fun removeItem(position: Int) {
        val newList = currentList.toMutableList() // 기존 어댑터의 데이터를 변경 가능한 상태로 준비 해둔다
        newList.removeAt(position) // 지우고 싶은 포지션을 전달 받아서 그 부분만 지워준다
        submitList(newList) // 작업이 끝난 리스트를 전달한다
    }

}