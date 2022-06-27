package com.trei.testproject.ui.fragments.home.images


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.data.entities.ImageListItem
import com.trei.testproject.databinding.AlbumListBinding
import com.trei.testproject.databinding.AlbumPictureBinding
import com.trei.testproject.ui.fragments.home.HomeAdapter
import com.trei.testproject.ui.fragments.home.HomeViewHolder
import com.trei.testproject.utils.Resource

class ImageAdapter(
    private val context: Context,
    private val listener: OnClickListener,
) : RecyclerView.Adapter<ImageViewHolder>() {

    interface OnClickListener {
    }

    companion object{
        val noOfItems = 3
    }

    private val items = ArrayList<ImageListItem>()

    fun setItems(items: ArrayList<ImageListItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImageViewHolder {
        val binding: AlbumPictureBinding =
            AlbumPictureBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageViewHolder(context, binding, listener)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
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

