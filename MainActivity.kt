package com.example.labact6_supplementary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var pictureData: TextView? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var manage: RecyclerView.LayoutManager
    private lateinit var Adapt: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manage = LinearLayoutManager(this)
        pictureData = findViewById(R.id.IdView)
        findViewById<View>(R.id.button).setOnClickListener {
            getCurrentData()
        }

    }
    private fun getCurrentData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CardService::class.java)
        val call = service.getCardData()
        call.enqueue(object : Callback<List<CardAttributes>>{
            override fun onResponse(
                call: Call<List<CardAttributes>>,
                response: retrofit2.Response<List<CardAttributes>>
            ){
                if (response.code() == 200) {
                    val cardAttributes = response.body()!!
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
                        Adapt = ImageAdapter(response.body()!!)
                        layoutManager = manage
                        adapter = Adapt
                    }
                    val stringBuilder = "ID: " +
                            cardAttributes[0].id +
                            "\n" +
                            "Author: " +
                            cardAttributes[1].author
                }
            }

            override fun onFailure(call: Call<List<CardAttributes>>, t: Throwable) {
                pictureData!!.text = t.message
            }
        })
    }
    companion object {
        var BaseUrl =  "https://picsum.photos"

    }
}
