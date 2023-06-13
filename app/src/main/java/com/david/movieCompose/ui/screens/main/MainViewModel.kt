package com.david.movieCompose.ui.screens.main

import com.david.movieCompose.BaseViewModel
import com.david.movieCompose.UiState
import com.david.movieCompose.dommain.MovieItem
import com.david.movieCompose.dommain.MovieRepo
import com.david.movieCompose.runIoCoroutine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieRepo: MovieRepo) : BaseViewModel() {

    private val _movieListState = MutableStateFlow<UiState<List<MovieItem>>>(UiState.Loading)
    val movieListState: StateFlow<UiState<List<MovieItem>>> get() = _movieListState

    init {
        fetchMovieList()
    }

    private fun fetchMovieList() {
        runIoCoroutine {
            try {
                val movieList = movieRepo.getMovieList()
                _movieListState.value = UiState.Success(movieList)
            } catch (e: Exception) {
                _movieListState.value = UiState.Error(e)
            }
        }
    }
}
