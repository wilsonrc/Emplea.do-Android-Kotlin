package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryDataSource
import com.wilsonrc.empleado.data.models.JobCategory
import io.reactivex.Single
import javax.inject.Inject

class JobCategoryRemoteDataSource @Inject constructor(private val JobCategoryService: JobCategoryService) : JobCategoryDataSource {

    override fun getJobCategories(): Single<ArrayList<JobCategory>> {
        return JobCategoryService.getJobCategories()
    }

}