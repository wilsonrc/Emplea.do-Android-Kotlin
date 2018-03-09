package com.wilsonrc.empleado.data.source.models

/**
 * Created by Wilson Reyes on 3/9/2018.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JobsRequest {

    @SerializedName("data")
    @Expose
    var data: List<Job>? = null
    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("itemsPerPage")
    @Expose
    var itemsPerPage: Int? = null
    @SerializedName("totalItems")
    @Expose
    var totalItems: Int? = null

}