package com.dapoidev.catmov.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dapoidev.catmov.core.domain.useCase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favMovie = movieUseCase.getFavMovie().asLiveData()
}