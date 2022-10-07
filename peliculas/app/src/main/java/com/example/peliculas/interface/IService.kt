package com.example.peliculas.`interface`

import com.example.peliculas.Repo
import retrofit2.Call
import retrofit2.http.GET


interface IService {
    @GET("/3/movie/top_rated?api_key=cc75c1ffd69e293f1a215b697fba8588&language=en-US&page=1")
    fun listRepos(): Call<List<Repo>>
}