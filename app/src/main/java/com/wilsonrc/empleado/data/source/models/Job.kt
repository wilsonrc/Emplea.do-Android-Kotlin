package com.wilsonrc.empleado.data.source.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Job {

    @SerializedName("jobTitle")
    @Expose
    var jobTitle: String? = null
    @SerializedName("JobLink")
    @Expose
    var jobLink: String? = null
    @SerializedName("jobCompany")
    @Expose
    var jobCompany: String? = null
    @SerializedName("jobLocation")
    @Expose
    var jobLocation: String? = null
    @SerializedName("jobDate")
    @Expose
    var jobDate: String? = null
    @SerializedName("jobCategory")
    @Expose
    var jobCategory: String? = null
    @SerializedName("jobType")
    @Expose
    var jobType: String? = null

}