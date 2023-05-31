package com.david.network

import com.david.network.dto.MovieDetails
import com.david.network.dto.MovieList
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.cache.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json


interface IMovieService {

    suspend fun getPopular(
    ): MovieList?


    suspend fun getMovieDetails(id: Int): MovieDetails?

    companion object {
        fun create(): IMovieService {

            return MovieServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.INFO
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                    install(HttpCache)
                },
                json = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                }

            )
        }
    }
}
