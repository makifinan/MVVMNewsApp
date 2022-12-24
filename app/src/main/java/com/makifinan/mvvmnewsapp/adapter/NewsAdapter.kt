package com.makifinan.mvvmnewsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makifinan.mvvmnewsapp.R
import com.makifinan.mvvmnewsapp.model.Article

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(view:View):RecyclerView.ViewHolder(view){
        lateinit var ivArticleImage : ImageView
        lateinit var tvTitle : TextView
        lateinit var tvDescription:TextView
        lateinit var tvSource:TextView
        lateinit var tvPublishedAt:TextView
        init {
            ivArticleImage=view.findViewById(R.id.ivArticleImage)
            tvTitle=view.findViewById(R.id.tvTitle)
            tvDescription=view.findViewById(R.id.tvDescription)
            tvSource=view.findViewById(R.id.tvSource)
            tvPublishedAt=view.findViewById(R.id.tvPublishedAt)
        }
    }
    private val differCallBack= object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }

    private val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val design = LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview,parent,false)
        return ArticleViewHolder(design)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.ivArticleImage)
            holder.tvDescription.text=article.description
            holder.tvTitle.text=article.title
            holder.tvSource.text=article.source.name
            holder.tvPublishedAt.text=article.publishedAt
            setOnClickListener {
                onItemClickListener?.let {
                    it(article)
                }
            }


        }
    }
    private var onItemClickListener : ((Article) -> Unit)?=null

    fun setOnItemClickListener(listener:(Article) -> Unit){
        onItemClickListener=listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}