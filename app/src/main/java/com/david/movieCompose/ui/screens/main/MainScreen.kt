package com.david.movieCompose.ui.screens.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()

) {
    val movieListState by viewModel.movieListState.collectAsState()

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
    ) {
        when (movieListState) {
            is UiState.Loading -> {
                // Display a loading indicator
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            is UiState.Success -> {
                val movieList: List<MovieItem> =
                    (movieListState as UiState.Success<List<MovieItem>>).data
                // Display the list of movies
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(movieList) { movie ->
                        CharacterItem(movieItem = movie, coroutineScope = coroutineScope)
                    }
                }
            }

            is UiState.Error -> {
                // Display an error message
                val errorMessage = (movieListState as UiState.Error).exception.message
                Text(
                    text = errorMessage ?: "An error occurred",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(
    movieItem: MovieItem,
    coroutineScope: CoroutineScope
) {
    var isSelected by remember { mutableStateOf(false) }

    val cardColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.surfaceVariant,
        animationSpec = tween(durationMillis = 200)
    )


    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(8.dp),
        onClick = {
            isSelected = !isSelected
            coroutineScope.launch {
                delay(200)
                isSelected = false
            }
        }
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
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = movieItem.release_date,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = movieItem.overview.take(200),
                    fontSize = 14.sp,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                    else MaterialTheme.colorScheme.onSurface,
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
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
