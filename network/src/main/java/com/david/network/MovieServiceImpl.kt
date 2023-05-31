package com.david.network

import android.util.Log
import com.david.network.dto.MovieDetails
import com.david.network.dto.MovieList

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json


class MovieServiceImpl(
    private val client: HttpClient,
    private val json: Json
) : IMovieService {

    private fun handleException(e: Exception) {
        when (e) {
            // 3xx - responses
            is RedirectResponseException -> Log.w(MODEL_TAG, "Redirect", e)
            // 4xx - responses
            is ClientRequestException -> Log.w(MODEL_TAG, "Client Error", e)
            // 5xx - responses
            is ServerResponseException -> Log.w(MODEL_TAG, "Server Error", e)
            else -> Log.w(MODEL_TAG, "Other Error", e)
        }
    }

    override suspend fun getPopular(): MovieList? {
        return try {
            val movieResult: String = client.get {
                url(HttpRoutes.POPULAR)
            }
            json.decodeFromString(string = movieResult, deserializer = MovieList.serializer())
        } catch (e: Exception) {
            handleException(e)
            null
        }
    }

    override suspend fun getMovieDetails(id: Int): MovieDetails? {
        return try {
            val url: String = "${HttpRoutes.DETAILS}/$id?${HttpRoutes.API_KEY}"
            client.get {
                url(url)
            }
        } catch (e: Exception) {
            handleException(e)
            null
        }


    }

}