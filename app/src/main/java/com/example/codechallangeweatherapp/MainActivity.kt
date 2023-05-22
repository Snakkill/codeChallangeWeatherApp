package com.example.codechallangeweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.codechallenge.Data.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val Base_Url ="https://api.openweathermap.org/data/2.5/"
const val key="74263b9a49d1177a1f44424e8fad66d9"


class MainActivity : AppCompatActivity() {
    lateinit var textInput: EditText
    lateinit var city:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getWeather(city: String, key: String) {
        // val intent = Intent(this, ResultsScreen::class.java)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_Url)
            .build()
            .create(API::class.java)

        val retrofitData = retrofitBuilder.getData(city,key)

        retrofitData.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>?, response: Response<WeatherData>?) {
                val responseBody = response?.body()!!

                println(responseBody)



            }

            override fun onFailure(call: Call<WeatherData>?, t: Throwable?) {
                Log.d("MainActivity","onFail:"+ t?.message)
            }
        })


    }


    fun searchCity(view: View) {
        try{
            textInput=findViewById(R.id.City)
            city=textInput.text.toString()
            println(city)

            if (city.isNullOrEmpty()){
                Toast.makeText(applicationContext, "Please enter valid city name", Toast.LENGTH_SHORT).show()
            }
            else{
                getWeather(city,key);

            }



        }  catch (e:Exception){
            println("exception in api call")
        }

    }
}