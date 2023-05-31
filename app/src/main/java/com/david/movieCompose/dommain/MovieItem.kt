package com.david.movieCompose.dommain

//data class PokeCoreDataCharacter(
//    val id: String,
//    val name: String,
//)
//
fun MovieItem.getImageUrl() =
    "https://image.tmdb.org/t/p/w500/$poster_path"

data class MovieItem(
    val backdrop_path: String?,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
) {
    override fun toString(): String {
        return "MovieItem(backdrop_path=$backdrop_path, id=$id, original_language='$original_language'" +
                ", original_title='$original_title', overview='$overview', poster_path=$poster_path, " +
                "release_date='$release_date', title='$title', video=$video)"

    }

    companion object {
        fun getEmpty(): MovieItem = MovieItem(
            backdrop_path = null,
            id = 0,
            original_language = "",
            original_title = "",
            overview = "",
            poster_path = null,
            release_date = "",
            title = "",
            video = false,
        )
    }
}
