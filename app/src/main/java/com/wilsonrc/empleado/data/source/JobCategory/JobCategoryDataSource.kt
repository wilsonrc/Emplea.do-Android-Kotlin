package com.wilsonrc.empleado.data.source.JobCategory

import com.wilsonrc.empleado.data.models.JobCategory
import io.reactivex.Single


interface JobCategoryDataSource {

    fun getJobCategories() : Single<ArrayList<JobCategory>>

}