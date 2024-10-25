package com.example.youtobe.data.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtobe.BuildConfig
import kotlinx.coroutines.Dispatchers
import com.example.youtobe.data.api.YouTubeApiService
import com.example.youtobe.data.model.BaseResponse
import com.example.youtobe.data.model.VideoModel
import com.example.youtobe.utils.Constants
import com.example.youtobe.utils.Resource

class YouTubeRepository(
    private val service: YouTubeApiService
) {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = service.getPlaylists(
                apiKey = BuildConfig.API_KEY,
                part = Constants.PART,
                channelId = Constants.CHANNEL_ID,
                maxResults = Constants.MAX_RESULTS
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it.items))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

    fun getPlaylistVideo(playlistId: String, listSize:Int): LiveData<Resource<List<VideoModel.Item>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = service.getPlaylistItems(
                    apiKey = BuildConfig.API_KEY,
                    part = Constants.PART,
                    playlistId = playlistId,
                    maxResults = listSize
                )
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it.items))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            }
        }

}