package com.wilsonrc.empleado.data.source.JobCategory

import com.wilsonrc.empleado.data.source.models.JobCategory
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import io.reactivex.Single


class JobCategoryRepository(private val jobCategoryRemoteDataSource : JobCategoryRemoteDataSource) : JobCategoryDataSource {

    override fun getJobCategories(): Single<ArrayList<JobCategory>> {
        return jobCategoryRemoteDataSource.getJobCategories()
    }

}