package com.example.vkintership.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.vkintership.R
import com.example.vkintership.data.model.GifModel
import com.example.vkintership.databinding.ActivityGifDetailsBinding

class GifDetailsActivity : AppCompatActivity() {

    private lateinit var gif: GifModel
    private lateinit var binding: ActivityGifDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGifDetailsBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        gif = intent.getSerializableExtra("gif") as GifModel
        displayData(gif)
    }

    // Можно отобразить и вообще всю информацию из ответа, однако не вижу в этом смысла
    private fun displayData(gif: GifModel) {
        binding.apply {
            Glide.with(baseContext)
                .load(gif.images?.fixedHeight?.url)
                .into(ivGifDetails)

            tvGifTitle.text = gif.title
            tvGifUsername.text = getString(R.string.gif_username, gif.username)
            tvGifSource.text = getString(R.string.gif_source, gif.source)
            if (gif.createDateTime != null) {
                tvGifDate.text = getString(R.string.gif_creation_date, gif.createDateTime)
            }
        }
    }
}
