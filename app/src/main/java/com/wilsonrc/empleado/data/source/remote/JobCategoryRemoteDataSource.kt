package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryDataSource
import com.wilsonrc.empleado.data.source.models.JobCategory
import io.reactivex.Single

class JobCategoryRemoteDataSource(private val JobCategoryService: JobCategoryService) : JobCategoryDataSource {

    override fun getJobCategories(): Single<ArrayList<JobCategory>> {
        return JobCategoryService.getJobCategories()
    }

}