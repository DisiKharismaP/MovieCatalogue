package disiiy.khaper.moviecatalogue.model.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PopularResponse(
        @SerializedName("page")
        val page:Int,
        @SerializedName("results")
        val result: ArrayList<MovieItemResponse>
)

