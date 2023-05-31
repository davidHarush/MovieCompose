package com.david.movieCompose.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.david.movieCompose.UiState
import com.david.movieCompose.dommain.MovieItem
import com.david.movieCompose.dommain.getImageUrl
import com.david.movieCompose.ui.theme.DeepBlue


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val pokeListState by viewModel.movieListState.collectAsState()

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        when (pokeListState) {
            is UiState.Loading -> {
                // Display a loading indicator
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            is UiState.Success -> {
                val movieList: ArrayList<MovieItem> =
                    (pokeListState as UiState.Success<ArrayList<MovieItem>>).data
                // Display the list of movies
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(movieList) { movie ->
                        CharacterItem(movieItem = movie)
                    }
                }
            }

            is UiState.Error -> {
                // Display an error message
                val errorMessage = (pokeListState as UiState.Error)
                Text(
                    text = errorMessage.exception.message!!,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red
                )
            }
        }
    }
}

@Composable
fun CharacterItem(
    movieItem: MovieItem,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp,
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
            .height(300.dp)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MovieImage(movieItem, modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top,
            ) {
                Text(
                    text = movieItem.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = movieItem.release_date,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = movieItem.overview.take(200),
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun MovieImage(movieItem: MovieItem, modifier: Modifier = Modifier) {
    Image(
        painter = rememberAsyncImagePainter(movieItem.getImageUrl()),
        contentDescription = null,
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentScale = ContentScale.Crop
    )

}
