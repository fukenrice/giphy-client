package com.example.vkintership.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vkintership.R
import com.example.vkintership.data.model.GifModel
import kotlinx.android.synthetic.main.gif_card.view.*

class GifAdapter(
    private val onItemClicked: (gif: GifModel) -> Unit,
    private val gifs: MutableList<GifModel>,
    private val drawGif: (url: String, view: ImageView) -> Unit,
) : RecyclerView.Adapter<GifAdapter.DataViewHolder>() {

    class DataViewHolder(
        private val onItemClicked: (gif: GifModel) -> Unit,
        private val drawGif: (url: String, view: ImageView) -> Unit,
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(gif: GifModel) {
            itemView.tvGifName.text = gif.title
            itemView.ivGif.layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            gif.images?.fixedHeight?.url?.let { drawGif(it, itemView.ivGif) }
            itemView.setOnClickListener { onItemClicked(gif) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GifAdapter.DataViewHolder = DataViewHolder(
        onItemClicked,
        drawGif,
        LayoutInflater.from(parent.context)
            .inflate(R.layout.gif_card, parent, false)
    )

    override fun onBindViewHolder(holder: GifAdapter.DataViewHolder, position: Int) {
        holder.bind(gifs[position])
    }

    override fun getItemCount(): Int = gifs.size

    fun addData(list: List<GifModel>) {
        gifs.addAll(list)
    }

    fun clear() {
        gifs.clear()
    }
}
