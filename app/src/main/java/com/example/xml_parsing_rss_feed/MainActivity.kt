package com.example.xml_parsing_rss_feed


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_parsing_rss_feed.API.APIClient
import com.example.xml_parsing_rss_feed.API.APIInterface
import com.example.xml_parsing_rss_feed.Model.Entry
import com.example.xml_parsing_rss_feed.Model.Feed
import com.example.xml_parsing_rss_feed.Resource.RVAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var mainRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRV = findViewById(R.id.rvMain)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface!!.getArchFeed().enqueue(object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                updateRV(response.body()!!.entries)
            }

            override fun onFailure(call: Call<Feed>, t: Throwable) {
                call.cancel()
            }
        })

    }


    private fun updateRV(entries: List<Entry>?) {
        mainRV.adapter = RVAdapter(entries)
        mainRV.layoutManager = LinearLayoutManager(applicationContext)
    }


}