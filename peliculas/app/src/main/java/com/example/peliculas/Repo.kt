package com.example.peliculas

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
    @Expose @SerializedName("page") val id: Int
)