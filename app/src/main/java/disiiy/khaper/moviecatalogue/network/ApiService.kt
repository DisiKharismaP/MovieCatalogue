package disiiy.khaper.moviecatalogue.network

import android.graphics.Movie
import disiiy.khaper.moviecatalogue.model.movie.MovieUpcomingItemResponse
import disiiy.khaper.moviecatalogue.model.movie.PopularResponse
import disiiy.khaper.moviecatalogue.model.movie.UpcomingResponse
import disiiy.khaper.moviecatalogue.model.tv.TVPopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //movie
    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apikey: String,
        @Query("page") page: Int
    ): retrofit2.Call<PopularResponse>

    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apikey: String,
        @Query("page") page: Int
    ): retrofit2.Call<MovieUpcomingItemResponse>

    //TV
    @GET("tv/popular")
    fun getTVPopular(
            @Query("api_key") apikey: String,
            @Query("page") page: Int
    ): retrofit2.Call<TVPopularResponse>


}