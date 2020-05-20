package com.muhammadali.udemy.jetpack.databinding.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammad Ali on 29-Apr-20.
 * Email muhammad.ali9385@gmail.com
 */
@Entity
data class DogBreed(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val breed: String? = null,
    @SerializedName("life_span")
    val lifespan: String? = null,
    @SerializedName("breed_group")
    val breedGroup: String? = null,
    @SerializedName("temperament")
    val temperament: String? = null,
    @SerializedName("url")
    val image: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {

    }

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(breed)
        parcel.writeString(lifespan)
        parcel.writeString(breedGroup)
        parcel.writeString(temperament)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DogBreed> {
        override fun createFromParcel(parcel: Parcel): DogBreed {
            return DogBreed(parcel)
        }

        override fun newArray(size: Int): Array<DogBreed?> {
            return arrayOfNulls(size)
        }
    }
}