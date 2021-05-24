package com.dapoidev.catmov.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,

    val coverMovie: String,

    val title: String,

    val date: String,

    val vote_average: Double,

    val desc: String,

    val isFav: Boolean
): Parcelable