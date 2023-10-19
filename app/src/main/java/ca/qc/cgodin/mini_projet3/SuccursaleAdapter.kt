package ca.qc.cgodin.mini_projet3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cgodin.mini_projet3.models.Student
import com.bumptech.glide.Glide

class SuccursaleAdapter : RecyclerView.Adapter<SuccursaleAdapter.SuccursaleViewHolder>() {
    private var student: List<Student> = emptyList()

    inner class SuccursaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val ivCoverImage: ImageView = itemView.findViewById(R.id.ivCoverImage)
        //val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

        override fun toString(): String {
            //return super.toString() + " '" + tvTitle.text + "'"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SuccursaleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return SuccursaleViewHolder(view)
    }

    override fun getItemCount(): Int = articles.size


    override fun onBindViewHolder(holderArticle: ArticleViewHolder, position: Int)
    {
        val article = articles[position]
        holderArticle.tvTitle.text = article.title
        holderArticle.itemView.apply {

            Glide.with(this).load(article.urlToImage).into(holderArticle.ivCoverImage)
            holderArticle.tvTitle.text = article.title
        }
        holderArticle.itemView.setOnClickListener {
            onItemClickListener(article)
        }
        Log.i("", "Je suis l'article $article")
    }
    fun setArticles(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

}