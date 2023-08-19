
<h1 align="center">MovieCompose</h1>

<p align="center">
  🎬 MovieCompose is an Android app showcasing Android development with Hilt, Coroutines, Flow, Jetpack Compose, Ktor, and Material Design based on MVVM architecture.
</p>

</br>

<p align="center">
  <img src="https://img.shields.io/github/languages/top/davidHarush/MovieCompose.svg" alt="GitHub top language">
  <img src="https://img.shields.io/badge/API-31%2B-brightgreen.svg?style=flat" alt="API level">
  <a href="https://www.codefactor.io/repository/github/davidharush/moviecompose"><img src="https://www.codefactor.io/repository/github/davidharush/moviecompose/badge" alt="CodeFactor" /></a> 
<img src="https://img.shields.io/github/repo-size/davidHarush/MovieCompose" alt="GitHub repo size">
<img src="https://img.shields.io/github/issues/davidHarush/MovieCompose" alt="GitHub issues">
</p>

</br>

This app is developed using Jetpack Compose, the modern toolkit for building native UI in Android. It utilizes various libraries and frameworks to demonstrate best practices in Android development.

The main features of the app include:
- Displaying a list of popular movies.
- Viewing movie details and information.
- Fetching data from a remote server using Ktor.
- Asynchronous programming with Coroutines and Flow.
- Dependency injection with Hilt.
- Material Design components for a visually appealing UI.

This project serves as a learning resource and can be used as a starting point for building your own movie-related applications with Jetpack Compose and other modern Android technologies.

</br>

## Tech Stack
- Minimum SDK level 32
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous programming.
- Jetpack Compose for building the UI.
- MVVM (Model-View-ViewModel) architecture.
- [Ktor](https://ktor.io/) is a powerful networking library that allows you to write asynchronous client and server applications in Kotlin without relying on Android-specific dependencies. It provides a convenient and efficient way to perform network calls and handle responses.
for networking with the TMDB API
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- [Kotlin Serializable](https://kotlinlang.org/docs/serialization.html) for object serialization.

#### Network 

All the network calls from sepred modle using Ktor with Kotlin serializable.
</br>
Ktor: KMM framework that allow to write asynchronous clients and servers applications, in Kotlin without android dependency.
</br>
For more info [Ktor](https://ktor.io/), [Kotlin serializable](https://kotlinlang.org/docs/serialization.html)

#### Material Design 3

Material Design 3 is the latest version of Google's design language, providing updated guidelines and components for creating modern and visually appealing user interfaces.
In this project, I have adapted to Material Design 3 and used dynamicColorScheme based off the system wallpaper.

- [Material Design Documentation](https://material.io/design)
- [Material Components for Android](https://github.com/material-components/material-components-android)





</br>

## Screenshots

<p align="center">
  <img src="/art/screenshot1.jpeg" width="15%" alt="Screenshot 1" />
  <img src="/art/screenshot2.jpeg" width="15%" alt="Screenshot 2" />
  <img src="/art/screenshot4.jpeg" width="15%" alt="Screenshot 4" />
  <img src="/art/screenshot3.jpeg" width="15%" alt="Screenshot 3" />
</p>

## Diagram 

<p align="center">
  <img src="/art/Screenshot 2023-08-19 at 14.07.18.png" alt="Screenshot 1" />
</p>

