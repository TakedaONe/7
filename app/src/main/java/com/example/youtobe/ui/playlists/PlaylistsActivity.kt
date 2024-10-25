package com.example.youtobe.ui.playlists

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.youtobe.data.base.BaseActivity
import com.example.youtobe.data.model.BaseResponse
import com.example.youtobe.databinding.ActivityMainBinding
import com.example.youtobe.ui.playlistItems.PlaylistItemsActivity
import com.example.youtobe.ui.playlists.adapter.PlaylistsAdapter
import com.example.youtobe.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistsActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  viewModel:PlaylistsViewModel by viewModel()
    private lateinit var adapter: PlaylistsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getPlaylists().stateHandler(
            success = {
                adapter = PlaylistsAdapter(this::onClick)
                adapter.submitList(it)
                binding.recyclerView.adapter = adapter
            },
            state = {
                binding.progressBar.isVisible = it is Resource.Loading
            }
        )
    }


    private fun onClick(item: BaseResponse.Item) {
        val intent = Intent(this, PlaylistItemsActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("size", item.contentDetails.itemCount)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("description", item.snippet.description)
        startActivity(intent)
    }
}