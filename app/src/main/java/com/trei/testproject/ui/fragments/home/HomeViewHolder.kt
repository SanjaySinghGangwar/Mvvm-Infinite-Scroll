package com.trei.testproject.ui.fragments.home

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trei.testproject.data.entities.AlbumModelItem
import com.trei.testproject.data.entities.ImageListItem
import com.trei.testproject.databinding.AlbumListBinding
import com.trei.testproject.ui.fragments.home.images.ImageAdapter
import com.trei.testproject.utils.CircularScrollListenerImage
import com.trei.testproject.utils.Resource


class HomeViewHolder(
    private val context: Context,
    private val bind: AlbumListBinding,
    private val listener: HomeAdapter.OnClickListener,
    private val viewModel: HomeViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
) : RecyclerView.ViewHolder(bind.root), HomeAdapter.OnClickListener, ImageAdapter.OnClickListener {

    private lateinit var items: AlbumModelItem

    private var imageAdapter: ImageAdapter? = null


    init {
        imageAdapter = ImageAdapter(context, this)
        bind.albumPictureRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val scroll= CircularScrollListenerImage()
        bind.albumPictureRecycler.addOnScrollListener(scroll)

        bind.albumPictureRecycler.adapter = imageAdapter
    }

    fun bind(data: AlbumModelItem) {
        items = data
        bind.title.text = items.title
        getImagesFromServer(items.id)
    }

    private fun getImagesFromServer(id: Int) {

        viewModel.start(id)

        viewModel.images.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    imageAdapter?.setItems(it.data as ArrayList<ImageListItem>)
                }
                Resource.Status.ERROR -> {

                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {

                }
            }
        }
    }


}