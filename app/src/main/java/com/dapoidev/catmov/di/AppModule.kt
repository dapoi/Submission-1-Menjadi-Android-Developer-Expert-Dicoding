package com.dapoidev.catmov.di

import com.dapoidev.catmov.core.domain.useCase.MovieInteractor
import com.dapoidev.catmov.core.domain.useCase.MovieUseCase
import com.dapoidev.catmov.detail.DetailMovieViewModel
import com.dapoidev.catmov.home.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}