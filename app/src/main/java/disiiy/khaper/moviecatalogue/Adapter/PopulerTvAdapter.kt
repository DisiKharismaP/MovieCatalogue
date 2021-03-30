package disiiy.khaper.moviecatalogue.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import disiiy.khaper.moviecatalogue.BuildConfig
import disiiy.khaper.moviecatalogue.R
import disiiy.khaper.moviecatalogue.model.movie.MovieItemResponse
import disiiy.khaper.moviecatalogue.model.tv.TVPopularItemResponse
import kotlinx.android.synthetic.main.item_populer_movie.view.*
import kotlinx.android.synthetic.main.item_tv_popular.view.*

class PopulerTvAdapter(var listTvPopular : List<TVPopularItemResponse>)
    : RecyclerView.Adapter<PopulerTvAdapter.TvPopularViewHolder>() {

    class TvPopularViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(tvpopular : TVPopularItemResponse){
            with(itemView){
                Glide.with(context)
                        .load(BuildConfig.IMAGE_URL + tvpopular.poster_path)
                        .into(iv_tv_popular)
                tv_popular_title_tv.text =  tvpopular.name
                tv_original_lang.text = tvpopular.original_language

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopulerTvAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tv_popular, parent, false))
    }

    override fun getItemCount(): Int = listTvPopular.size

    override fun onBindViewHolder(holder: PopulerTvAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular.get(position))
    }

}