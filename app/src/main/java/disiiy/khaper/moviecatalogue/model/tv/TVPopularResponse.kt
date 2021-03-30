package disiiy.khaper.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TVPopularResponse(
    @SerializedName("page")
    val page :Int,
    @SerializedName("results")
    val results :ArrayList<TVPopularItemResponse>
)
