package com.wilsonrc.empleado.data.source.JobCategory

import com.wilsonrc.empleado.data.models.JobCategory
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject


class JobCategoryRepository @Inject constructor(private val jobCategoryRemoteDataSource : JobCategoryRemoteDataSource) : JobCategoryDataSource {

    override fun getJobCategories(): Single<ArrayList<JobCategory>> {
        return jobCategoryRemoteDataSource.getJobCategories()
    }

}