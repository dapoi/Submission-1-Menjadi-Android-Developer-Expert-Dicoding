package com.dapoidev.catmov.core.source.remote.network

import com.dapoidev.catmov.core.BuildConfig
import com.dapoidev.catmov.core.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getMovies(): ListMovieResponse
}