package com.example.codechallangeweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.Math.ceil

class ResultsScreen : AppCompatActivity() {

    lateinit var tempText: TextView
    lateinit var hightempText: TextView
    lateinit var lowtempText: TextView
    lateinit var mainIcon: ImageView
    lateinit var cityText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        tempText=findViewById(R.id.temp)
        mainIcon=findViewById(R.id.weatherIcon)
        cityText=findViewById(R.id.city)
        hightempText=findViewById(R.id.hightext)
        lowtempText=findViewById(R.id.lowtext)

        var temp=intent.getStringExtra("temp")
        val icon=intent.getStringExtra("icon")
        val city=intent.getStringExtra("city")
        var hightemp=intent.getStringExtra("high_temp")
        var lowtemp=intent.getStringExtra("low_temp")
        println(city)


        //to double, then convert from K to F , round up, then to String and
        temp= ceil(((temp!!.toDouble() - 273.15) * 9/5 + 32) ).toString()
        hightemp=ceil(((hightemp!!.toDouble() - 273.15) * 9/5 + 32) ).toString()
        lowtemp=ceil(((lowtemp!!.toDouble() - 273.15) * 9/5 + 32) ).toString()

        tempText.text=temp
        cityText.text=city.toString()
        hightempText.text=hightemp.toString()
        lowtempText.text=lowtemp.toString()

        Picasso.get()
            .load("https://openweathermap.org/img/wn/"+icon+"@2x.png")
            .resize(250,250).into(mainIcon)

    }

}