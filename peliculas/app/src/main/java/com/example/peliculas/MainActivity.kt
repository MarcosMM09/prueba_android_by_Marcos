package com.example.peliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.peliculas.`interface`.IService

import org.imaginativeworld.whynotimagecarousel.CarouselItem

import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.OnItemClickListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(IService::class.java)
        val repos = service.listRepos()

        repos.enqueue(object : Callback<List<Repo>>{
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                response.body()?.let { repos ->

                }
            }
        })


        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://www.themoviedb.org/t/p/w220_and_h330_face/nODIZa8p2Y31CKlp5JS0LFRmeXF.jpg"))
        list.add(CarouselItem("https://www.themoviedb.org/t/p/w220_and_h330_face/cOWPC7Sg9xoDM5i3uzs4iQtSPUj.jpg"))
        list.add(CarouselItem("https://www.themoviedb.org/t/p/w220_and_h330_face/djM2s4wSaATn4jVB33cV05PEbV7.jpg"))
        carousel.addData(list)

        carousel.onItemClickListener = object : OnItemClickListener{
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                if(position==1){
                    startActivity(Intent(this@MainActivity,actividad2::class.java))
                }
                else{
                    Toast.makeText(this@MainActivity,"Clic elemento $position",Toast.LENGTH_LONG).show()
                }


            }

            override fun onLongClick(position: Int, dataObject: CarouselItem) {
                Toast.makeText(this@MainActivity,"Clic largo a elemento $position",Toast.LENGTH_LONG).show()
            }
        }

    }


}
