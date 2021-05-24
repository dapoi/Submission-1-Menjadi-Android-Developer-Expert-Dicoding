package com.dapoidev.catmov.core.source

import com.dapoidev.catmov.core.domain.model.Movie
import com.dapoidev.catmov.core.domain.repository.IMovieRepository
import com.dapoidev.catmov.core.source.local.LocalDataSource
import com.dapoidev.catmov.core.source.remote.RemoteDataSource
import com.dapoidev.catmov.core.source.remote.network.ApiResponse
import com.dapoidev.catmov.core.source.remote.response.MovieResponse
import com.dapoidev.catmov.core.utils.AppExecutors
import com.dapoidev.catmov.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {


    override fun getListMovie(): Flow<Resource<List<Movie>>> =
        object : com.dapoidev.catmov.core.source.NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getListMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getListMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val moviesEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute {
            localDataSource.setFavMovie(moviesEntity, state)
        }
    }


}