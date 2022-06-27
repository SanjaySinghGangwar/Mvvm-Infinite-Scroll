package com.trei.testproject.ui.fragments.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.databinding.AlbumListBinding

class HomeAdapter(
    private val context: Context,
    private val listener: OnClickListener,
    private val viewModel: HomeViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
) : RecyclerView.Adapter<HomeViewHolder>() {

    companion object{
        val noOfItems = 3
    }

    interface OnClickListener {

    }

    private val items = ArrayList<AlbumModelItem>()

    fun setItems(items: ArrayList<AlbumModelItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomeViewHolder {
        val binding: AlbumListBinding =
            AlbumListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeViewHolder(context, binding, listener,viewModel,viewLifecycleOwner)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return if(items.isEmpty()){
            0
        }else{
            noOfItems * 2
        }
    }



}

