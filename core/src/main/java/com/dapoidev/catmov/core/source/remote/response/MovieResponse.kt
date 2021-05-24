package com.dapoidev.catmov.core.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val id: Int,

    @SerializedName("poster_path")
    val coverMovie: String,

    val title: String,

    @SerializedName("release_date")
    val date: String,

    val vote_average: Double,

    @SerializedName("overview")
    val desc: String
)
