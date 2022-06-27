package com.trei.testproject.ui.fragments.home.images

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.trei.testproject.R
import com.trei.testproject.data.entities.ImageListItem
import com.trei.testproject.databinding.AlbumPictureBinding
import com.trei.testproject.ui.fragments.home.HomeAdapter


class ImageViewHolder(
    private val context: Context,
    private val bind: AlbumPictureBinding,
    private val listener: ImageAdapter.OnClickListener,
) : RecyclerView.ViewHolder(bind.root), HomeAdapter.OnClickListener {

    private lateinit var items: ImageListItem

    init {

    }

    fun bind(data: ImageListItem) {
        items = data
        val url = GlideUrl(
            data.thumbnailUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        Glide.with(context)
            .load(url)
            .error(R.drawable.picture)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(bind.imageView);
    }


}