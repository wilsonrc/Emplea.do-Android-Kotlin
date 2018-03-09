package com.wilsonrc.empleado.data.source.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Job {

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
    @SerializedName("categoryId")
    @Expose
    var categoryId: Int? = null
    @SerializedName("categoryName")
    @Expose
    var categoryName: String? = null
    @SerializedName("companyName")
    @Expose
    var companyName: String? = null
    @SerializedName("companyUrl")
    @Expose
    var companyUrl: Any? = null
    @SerializedName("companyEmail")
    @Expose
    var companyEmail: String? = null
    @SerializedName("companyLogoUrl")
    @Expose
    var companyLogoUrl: Any? = null
    @SerializedName("viewCount")
    @Expose
    var viewCount: Int? = null
    @SerializedName("hireTypeId")
    @Expose
    var hireTypeId: Int? = null
    @SerializedName("hireTypeName")
    @Expose
    var hireTypeName: String? = null
    @SerializedName("isRemote")
    @Expose
    var isRemote: Boolean? = null
    @SerializedName("publishedDateRaw")
    @Expose
    var publishedDateRaw: String? = null
    @SerializedName("publishedDate")
    @Expose
    var publishedDate: String? = null
}