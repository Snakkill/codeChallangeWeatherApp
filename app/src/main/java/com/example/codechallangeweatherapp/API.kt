package com.example.codechallangeweatherapp
import com.example.codechallenge.Data.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//weather?q=Plano&appid=74263b9a49d1177a1f44424e8fad66d9

interface API {
    @GET("weather")
    fun getData(
        @Query("q") city:String,
        @Query("appid") key:String
    ): Call<WeatherData>
}



