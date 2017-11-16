package com.wilsonrc.empleado.data.source.JobCategory

import com.wilsonrc.empleado.data.source.models.JobCategory
import io.reactivex.Single


interface JobCategoryDataSource {

    fun getJobCategories() : Single<ArrayList<JobCategory>>

}