package com.dapoidev.catmov.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dapoidev.catmov.core.domain.useCase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getListMovie().asLiveData()
}