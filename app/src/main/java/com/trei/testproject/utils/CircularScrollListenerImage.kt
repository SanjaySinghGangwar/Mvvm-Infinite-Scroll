package com.trei.testproject.utils

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trei.testproject.ui.fragments.home.images.ImageAdapter

class CircularScrollListenerImage : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val firstItemVisible: Int = layoutManager.findFirstVisibleItemPosition()
        val lastPosition: Int = layoutManager.findLastVisibleItemPosition()


        Log.i("TAG", "onScrolled: LastPostion " + lastPosition)
        Log.i("TAG", "onScrolled: dx " + dx)
        Log.i("TAG", "onScrolled: dy " + dy)
        Log.i("TAG", "onScrolled: layoutManager " + layoutManager)


        /*if (firstItemVisible == 0) {
            layoutManager.scrollToPositionWithOffset(
                HomeAdapter.noOfItems,
                -recyclerView.computeHorizontalScrollOffset()
            )
        }*/

        if (lastPosition == 5) {
            layoutManager.scrollToPosition(0)
        }

        if (!recyclerView.canScrollVertically(1) && recyclerView.scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            Log.d("-----", "end");

        }


    }
}