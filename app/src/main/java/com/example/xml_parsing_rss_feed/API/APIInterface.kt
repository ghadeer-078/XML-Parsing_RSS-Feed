package com.example.xml_parsing_rss_feed.API

import com.example.xml_parsing_rss_feed.Model.Feed
import retrofit2.Call
import retrofit2.http.GET


interface APIInterface {
    @GET("archlinux/.rss")
    fun getArchFeed() : Call<Feed>
}