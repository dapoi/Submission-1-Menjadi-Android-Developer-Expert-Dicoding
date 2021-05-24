package com.dapoidev.catmov.core.domain.useCase

import com.dapoidev.catmov.core.source.Resource
import com.dapoidev.catmov.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getListMovie(): Flow<Resource<List<Movie>>>

    fun getFavMovie(): Flow<List<Movie>>

    fun setFavMovie(movie: Movie, state: Boolean)
}