package com.dapoidev.catmov.core.utils

import com.dapoidev.catmov.core.domain.model.Movie
import com.dapoidev.catmov.core.source.local.entitiy.MovieEntity
import com.dapoidev.catmov.core.source.remote.response.MovieResponse

object DataMapper {
    fun mapResponseToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                coverMovie = it.coverMovie,
                title = it.title,
                date = it.date,
                vote_average = it.vote_average,
                desc = it.desc,
                isFav = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                coverMovie = it.coverMovie,
                title = it.title,
                date = it.date,
                vote_average = it.vote_average,
                desc = it.desc,
                isFav = it.isFav
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        coverMovie = input.coverMovie,
        title = input.title,
        date = input.date,
        vote_average = input.vote_average,
        desc = input.desc,
        isFav = input.isFav
    )
}