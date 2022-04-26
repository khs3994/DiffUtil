package com.example.diffutil

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MyItemTouchHelperCallback(private val recyclerView: RecyclerView) : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN, // 어느 방향으로 움직일건지
    ItemTouchHelper.LEFT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        (recyclerView.adapter as MyRecyclerViewAdapter).moveItem(
            viewHolder.adapterPosition, //움직이기 전 위치
            target.adapterPosition // 움직인 후 위치
        )
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) { // 삭제기능
        (recyclerView.adapter as MyRecyclerViewAdapter).removeItem(viewHolder.layoutPosition)
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) { // 아이템을 움직일때 투명화
        super.onSelectedChanged(viewHolder, actionState)
        when(actionState){
            ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.ACTION_STATE_SWIPE -> {
                (viewHolder as MyViewHolder).setAlpha(1.0f)
            }
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        (viewHolder as MyViewHolder).setAlpha(1.0f)
    }
}