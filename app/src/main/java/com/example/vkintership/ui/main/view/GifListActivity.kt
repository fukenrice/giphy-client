package com.example.vkintership.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.vkintership.R
import com.example.vkintership.data.api.Repository
import com.example.vkintership.data.model.GifModel
import com.example.vkintership.databinding.ActivityGifListBinding
import com.example.vkintership.ui.main.adapter.GifAdapter
import com.example.vkintership.ui.main.viewmodel.GifListViewModel
import com.example.vkintership.utils.Status

class GifListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGifListBinding
    private lateinit var viewModel: GifListViewModel
    private lateinit var adapter: GifAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGifListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupViewModel()
        setupObserver()
        setupUI()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                getData(query)
                return true
            }
        })
        searchView.isIconifiedByDefault = false
        return true
    }

    private fun setupUI() {
        binding.apply {
            rvGifs.layoutManager = LinearLayoutManager(baseContext)
            adapter = GifAdapter({ gif -> onGifClick(gif) },
                mutableListOf(),
                { url, view -> drawGif(url, view) })

            rvGifs.adapter = adapter
        }
    }

    private fun setupObserver() {
        viewModel.getGifs().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { it1 -> renderList(it1) }
                    Log.d("mytag", "got data, going to render")
                }
                Status.LOADING -> {
                    renderList(listOf())
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Log.d("errorloading", it.message.toString())
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = GifListViewModel(Repository())
    }

    private fun renderList(gifs: List<GifModel>) {
        adapter.clear()
        adapter.addData(gifs)
        adapter.notifyDataSetChanged()
    }

    private fun drawGif(url: String, view: ImageView) {
        Log.d("mytag", "trying to load gif with url: $url")
        Glide.with(this)
            .load(url)
            .into(view)
    }

    private fun onGifClick(gif: GifModel) {
        val intent = Intent(this, GifDetailsActivity::class.java)
        intent.putExtra("gif", gif)
        startActivity(intent)
    }

    private fun getData(query: String) {
        viewModel.fetchByQuery(query)
    }
}
