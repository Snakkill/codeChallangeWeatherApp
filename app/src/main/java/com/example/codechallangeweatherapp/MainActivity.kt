package com.example.codechallangeweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var textInput: EditText
    lateinit var city:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun searchCity(view: View) {
        try{
            textInput=findViewById(R.id.City)
            city=textInput.text.toString()
            println(city)


        }  catch (e:Exception){
            println("exception in api call")
        }

    }
}