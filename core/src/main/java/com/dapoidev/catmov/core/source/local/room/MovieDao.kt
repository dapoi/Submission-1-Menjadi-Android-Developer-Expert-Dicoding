package com.dapoidev.catmov.core.source.local.room

import androidx.room.*
import com.dapoidev.catmov.core.source.local.entitiy.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getListMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE isFav = 1")
    fun getFavMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieToFav(movie: List<MovieEntity>)

    @Update
    fun updateFavMovie(movie: MovieEntity)
}