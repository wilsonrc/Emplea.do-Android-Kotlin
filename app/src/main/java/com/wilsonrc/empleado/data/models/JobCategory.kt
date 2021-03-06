package com.wilsonrc.empleado.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class JobCategory {

    @SerializedName("id")
    @Expose
    var id : Int? = null

    @SerializedName("name")
    @Expose
    var name : String? = null

    @SerializedName("Description")
    @Expose
    var description : String? = null

    override fun toString(): String {
        return description.toString()
    }


}