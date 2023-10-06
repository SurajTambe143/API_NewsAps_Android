package com.example.apidemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class NewsAdapter(val context: Context ,val articles :List<Article>): RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) :ViewHolder(itemView){
        var imageView=itemView.findViewById<ImageView>(R.id.rv_image)
        var titleView=itemView.findViewById<TextView>(R.id.rv_title)
        var aboutView=itemView.findViewById<TextView>(R.id.rv_about)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.rv_item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.titleView.text=article.title
        holder.aboutView.text=article.description
        Glide.with(context).load(article.urlToImage).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return articles.size
    }

}