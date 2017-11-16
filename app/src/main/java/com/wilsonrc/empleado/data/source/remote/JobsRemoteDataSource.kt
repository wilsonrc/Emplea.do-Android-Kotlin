package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.jobs.JobsDataSource
import com.wilsonrc.empleado.data.source.models.Job
import io.reactivex.Observable
import io.reactivex.Single


class JobsRemoteDataSource(private val jobsService: JobsService) : JobsDataSource {


    override fun getJobs(page: String, pageSize: String, category: String): Observable<ArrayList<Job>> {

        var parameters:MutableMap<String, String> = mutableMapOf()

        parameters.put("page",page)

        parameters.put("PageSize",pageSize)

        parameters.put("JobCategory",category)

        return jobsService.getJobs(parameters)

    }


    override fun getJob(jobId: String): Single<Job> {

        return jobsService.getJob(jobId)

    }

}