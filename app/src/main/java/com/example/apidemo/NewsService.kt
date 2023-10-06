package com.example.apidemo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&apiKey=b275751a51ee46188f4e98dc6ab2e328
//https://newsapi.org/v2/top-headlines?country=in&apiKey=b275751a51ee46188f4e98dc6ab2e328

const val BASE_URL="https://newsapi.org"
const val API_KEY="b275751a51ee46188f4e98dc6ab2e328"

interface NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String,@Query("page") page:Int):Call<News>
}

object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}