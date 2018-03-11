package com.wilsonrc.empleado.data.source.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Job() : Parcelable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("howToApply")
    @Expose
    var howToApply: String? = null
    @SerializedName("companyName")
    @Expose
    var companyName: String? = null
    @SerializedName("companyUrl")
    @Expose
    var companyUrl: String? = null
    @SerializedName("companyEmail")
    @Expose
    var companyEmail: String? = null
    @SerializedName("companyLogoUrl")
    @Expose
    var companyLogoUrl: String? = null
    @SerializedName("locationName")
    @Expose
    var locationName: String? = null
    @SerializedName("locationLongitude")
    @Expose
    var locationLongitude: String? = null
    @SerializedName("locationLatitude")
    @Expose
    var locationLatitude: String? = null
    @SerializedName("categoryId")
    @Expose
    var categoryId: Int? = null
    @SerializedName("categoryName")
    @Expose
    var categoryName: String? = null
    @SerializedName("hireTypeId")
    @Expose
    var hireTypeId: Int? = null
    @SerializedName("hireTypeName")
    @Expose
    var hireTypeName: String? = null
    @SerializedName("viewCount")
    @Expose
    var viewCount: Int? = null
    @SerializedName("isRemote")
    @Expose
    var isRemote: Boolean? = null
    @SerializedName("publishedDateRaw")
    @Expose
    var publishedDateRaw: String? = null
    @SerializedName("publishedDate")
    @Expose
    var publishedDate: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        description = parcel.readString()
        howToApply = parcel.readString()
        companyName = parcel.readString()
        companyUrl = parcel.readString()
        companyEmail = parcel.readString()
        companyLogoUrl = parcel.readString()
        locationName = parcel.readString()
        locationLongitude = parcel.readString()
        locationLatitude = parcel.readString()
        categoryId = parcel.readValue(Int::class.java.classLoader) as? Int
        categoryName = parcel.readString()
        hireTypeId = parcel.readValue(Int::class.java.classLoader) as? Int
        hireTypeName = parcel.readString()
        viewCount = parcel.readValue(Int::class.java.classLoader) as? Int
        isRemote = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        publishedDateRaw = parcel.readString()
        publishedDate = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(howToApply)
        parcel.writeString(companyName)
        parcel.writeString(companyUrl)
        parcel.writeString(companyEmail)
        parcel.writeString(companyLogoUrl)
        parcel.writeString(locationName)
        parcel.writeString(locationLongitude)
        parcel.writeString(locationLatitude)
        parcel.writeValue(categoryId)
        parcel.writeString(categoryName)
        parcel.writeValue(hireTypeId)
        parcel.writeString(hireTypeName)
        parcel.writeValue(viewCount)
        parcel.writeValue(isRemote)
        parcel.writeString(publishedDateRaw)
        parcel.writeString(publishedDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Job> {
        override fun createFromParcel(parcel: Parcel): Job {
            return Job(parcel)
        }

        override fun newArray(size: Int): Array<Job?> {
            return arrayOfNulls(size)
        }
    }

}