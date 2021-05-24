package com.dapoidev.catmov.detail

import androidx.lifecycle.ViewModel
import com.dapoidev.catmov.core.domain.model.Movie
import com.dapoidev.catmov.core.domain.useCase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setMovieFav(movie: Movie, newState: Boolean) = movieUseCase.setFavMovie(movie, newState)
}