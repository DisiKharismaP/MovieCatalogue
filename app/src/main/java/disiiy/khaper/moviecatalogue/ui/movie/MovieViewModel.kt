package disiiy.khaper.moviecatalogue.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import disiiy.khaper.moviecatalogue.BuildConfig
import disiiy.khaper.moviecatalogue.model.movie.*
import disiiy.khaper.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    fun init(page: Int){
        getPopularMovie(page)
    }

    ///Data
    private val data = MutableLiveData<List<MovieItemResponse>>()

    private fun getPopularMovie(page: Int) {
        RetrofitConfig().getApiService().getPopular(BuildConfig.API_KEY, page)
            .enqueue(object: Callback<PopularResponse>{
                override fun onResponse(
                    call: Call<PopularResponse>,
                    response: Response<PopularResponse>
                ) {
                    if (response.isSuccessful){
                        val responseMovie : PopularResponse? = response.body()
                        data.postValue(responseMovie?.result!! as List<MovieItemResponse>?)
                    }
                }

                override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }

            })
    }

    //get all attribut
    fun getData(): LiveData<List<MovieItemResponse>>{
        return data
    }

    // call page
    fun initUp(page:Int){
        getUpcoming(page)
    }

    private val dataUpcoming = MutableLiveData<List<UpcomingResponse>>()

    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcoming(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MovieUpcomingItemResponse>{
                override fun onFailure(call: Call<MovieUpcomingItemResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }

                override fun onResponse(call: Call<MovieUpcomingItemResponse>, response: Response<MovieUpcomingItemResponse>) {
                    if(response.isSuccessful){
                        val upcomingResponse : MovieUpcomingItemResponse? = response.body()
                        dataUpcoming.postValue(upcomingResponse?.result)
                    }
                }

            })
    }

    fun getDataUpcoming(): LiveData<List<UpcomingResponse>>{
        return dataUpcoming
    }

}