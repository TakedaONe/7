package com.example.youtobe.ui.playlistItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.youtobe.data.model.VideoModel
import com.example.youtobe.data.repository.YouTubeRepository


class VideoViewModel(private val repository: YouTubeRepository) : ViewModel() {

    fun getPlaylistVideo(getId: String, listSize: Int): LiveData<com.example.youtobe.utils.Resource<List<VideoModel.Item>>> =
        repository.getPlaylistVideo(getId, listSize)
}
