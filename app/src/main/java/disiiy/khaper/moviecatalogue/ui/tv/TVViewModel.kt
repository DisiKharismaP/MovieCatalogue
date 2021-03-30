package disiiy.khaper.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import disiiy.khaper.moviecatalogue.BuildConfig
import disiiy.khaper.moviecatalogue.model.movie.MovieItemResponse
import disiiy.khaper.moviecatalogue.model.movie.PopularResponse
import disiiy.khaper.moviecatalogue.model.tv.TVPopularItemResponse
import disiiy.khaper.moviecatalogue.model.tv.TVPopularResponse
import disiiy.khaper.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVViewModel : ViewModel() {
    fun initPopularTv(page : Int){
        getPopularTv(page)
    }

    private val dataPopularTv = MutableLiveData<List<TVPopularItemResponse>>()

    private fun getPopularTv(page: Int) {
        RetrofitConfig().getApiService().getTVPopular(BuildConfig.API_KEY, page)
                .enqueue(object : Callback<TVPopularResponse>{
                    override fun onFailure(call: Call<TVPopularResponse>, t: Throwable) {
                        Log.e("failure", t.toString())
                    }

                    override fun onResponse(call: Call<TVPopularResponse>, response: Response<TVPopularResponse>) {
                        if (response.isSuccessful){
                            val responseTVPopular : TVPopularResponse? = response.body()
                            dataPopularTv.postValue(responseTVPopular?.results)
                        }
                    }
                })
    }

    fun getTvPopularData(): LiveData<List<TVPopularItemResponse>>{
        return dataPopularTv
    }

}