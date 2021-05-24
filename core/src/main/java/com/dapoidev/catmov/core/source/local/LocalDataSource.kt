package com.dapoidev.catmov.core.source.local

import com.dapoidev.catmov.core.source.local.entitiy.MovieEntity
import com.dapoidev.catmov.core.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {


    fun getListMovie(): Flow<List<MovieEntity>> = movieDao.getListMovie()

    fun getFavMovie(): Flow<List<MovieEntity>> = movieDao.getFavMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovieToFav(movieList)

    fun setFavMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        movieDao.updateFavMovie(movie)
    }
}