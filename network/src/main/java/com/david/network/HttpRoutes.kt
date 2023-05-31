package com.david.network

// POPULAR = https://api.themoviedb.org/3/movie/popular?api_key=56a778f90174e0061b6e7c69a5e3c9f2
// GENRE_LIST = https://api.themoviedb.org/3/genre/movie/list?api_key=56a778f90174e0061b6e7c69a5e3c9f2
//DETAILS =  https://api.themoviedb.org/3/movie/299536?api_key=56a778f90174e0061b6e7c69a5e3c9f2
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