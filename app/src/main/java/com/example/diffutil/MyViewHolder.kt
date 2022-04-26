package com.example.diffutil

import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.LayoutViewholderBinding
import com.google.android.material.snackbar.Snackbar

class MyViewHolder(private val binding: LayoutViewholderBinding) : //바인딩을 사용하기 위한 작업
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Student) { // 각 텍스트 뷰에 데이터 전달
        with(binding) {
            tvName.text = "Name: ${data.name}"
            tvSchool.text = "School: ${data.school}"
            tvGrade.text = "Grade: ${data.grade}"
            tvStats.text = "KR: ${data.stats[0]} / EN: ${data.stats[1]} / MT: ${data.stats[2]}"

            layoutViewholder.setOnClickListener {
                Snackbar.make(it, "Item  $layoutPosition touched!", Snackbar.LENGTH_SHORT).show() // 아이템을 선택했을때 몇번째가 선택되었는지 알려줌
            }
        }
    }

    fun setAlpha(alpha: Float) { // 아이템을 잡고 끌때 사용, 텍스트 뷰의 투명도 변경가능
        with(binding) {
            tvName.alpha = alpha
            tvSchool.alpha = alpha
            tvStats.alpha = alpha
            tvGrade.alpha = alpha
        }
    }
}