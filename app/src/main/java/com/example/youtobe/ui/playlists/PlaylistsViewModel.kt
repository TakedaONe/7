package com.example.youtobe.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtobe.data.model.BaseResponse
import com.example.youtobe.data.repository.YouTubeRepository
import com.example.youtobe.utils.Resource

class PlaylistsViewModel(private val repository: YouTubeRepository): ViewModel() {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = repository.getPlaylists()

}