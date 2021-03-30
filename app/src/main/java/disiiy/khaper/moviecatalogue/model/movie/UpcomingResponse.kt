package disiiy.khaper.moviecatalogue.model.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class UpcomingResponse(
		@SerializedName("poster_path")
		val poster_path:String,
		@SerializedName("title", alternate = ["name"])
		val title:String,
		@SerializedName("release_date")
		val release_date:String,
		@SerializedName("overview")
		val overview:String
)

