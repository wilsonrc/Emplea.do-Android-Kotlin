package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.jobs.JobsDataSource
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.data.source.models.JobsRequest
import io.reactivex.Observable
import io.reactivex.Single


class JobsRemoteDataSource(private val jobsService: JobsService) : JobsDataSource {


    override fun getJobs(page: String, pageSize: String, category: String): Observable<JobsRequest> {

        var parameters:MutableMap<String, String> = mutableMapOf()

        parameters.put("start",page)

        parameters.put("length",pageSize)

//        parameters.put("JobCategory",category)

        return jobsService.getJobs(parameters)

    }


    override fun getJob(jobId: String): Single<Job> {

        return jobsService.getJob(jobId)

    }

}