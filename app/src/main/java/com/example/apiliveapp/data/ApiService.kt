package com.example.apiliveapp.data

import com.example.apiliveapp.data.model.Fact
import com.example.apiliveapp.data.model.FactListResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://catfact.ninja"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("/fact")
    suspend fun getFact() : Fact

    @GET("/facts")
    suspend fun getFactList(@Query("page") page: Int) : FactListResponse
}

object CatFactApi {
    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}