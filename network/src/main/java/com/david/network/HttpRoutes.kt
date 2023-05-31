package com.david.network


object HttpRoutes {
    private const val BASE_URL: String = "https://api.themoviedb.org/3/"
    const val API_KEY = "api_key=${BuildConfig.API_KEY}"
    const val POPULAR = "$BASE_URL/movie/popular?$API_KEY"
    const val DETAILS = "$BASE_URL/movie"
    const val GENRE_LIST = "$BASE_URL/genre/movie/list?$API_KEY"

    object Param {
        const val QUERY = "query"
        const val PAGE = "page"

    }

}