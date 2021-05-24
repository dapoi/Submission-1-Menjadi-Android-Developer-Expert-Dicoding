package com.dapoidev.catmov.core.domain.repository

import com.dapoidev.catmov.core.source.Resource
import com.dapoidev.catmov.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getListMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
}