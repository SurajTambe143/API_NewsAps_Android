package com.example.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news=NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object:Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news=response.body()
                if (news!=null){
                    adapter= NewsAdapter(this@MainActivity,news.articles)
                    val rv=findViewById<RecyclerView>(R.id.rv_container)
                    rv.adapter=adapter
                    rv.layoutManager= LinearLayoutManager(this@MainActivity)
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("API Response","Failure")
            }

        })
    }
}