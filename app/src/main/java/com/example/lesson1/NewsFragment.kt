package com.example.lesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1.databinding.FragmentNewsBinding
import com.example.lesson1.databinding.NewsItemBinding

class NewsFragment : Fragment() {
    private val newsList = ArrayList<News>()

    //binding的用法
    private var _binding: FragmentNewsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        // binding的用法
        _binding = FragmentNewsBinding.inflate(inflater, container, false)


        initNews()
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(newsList)
        binding.recyclerView.adapter = adapter


        val view = binding.root
        return view
    }

    private fun initNews()
    {
        repeat(4) {
            newsList.add(News("takephotos", R.drawable.takephotos))
            newsList.add(News("icon", R.drawable.icon))
            newsList.add(News("submit", R.drawable.submit))
            newsList.add(News("position", R.drawable.position))
            newsList.add(News("setting", R.drawable.setting))
            newsList.add(News("map", R.drawable.map))
            newsList.add(News("handling", R.drawable.handling))
        }
    }
}
class News(val contain:String,val imageID:Int)
class NewsAdapter(val newsList:List<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>()
{
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val newsImage:ImageView=view.findViewById(R.id.newsImage)
        val newsContain:TextView=view.findViewById(R.id.newsContain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news=newsList[position]
        holder.newsImage.setImageResource(news.imageID)
        holder.newsContain.text = news.contain
    }

    override fun getItemCount()=newsList.size
}