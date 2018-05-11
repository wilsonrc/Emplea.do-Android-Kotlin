package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.jobs.JobsDataSource
import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobsRequest
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class JobsRemoteDataSource @Inject constructor(val jobsService: JobsService) : JobsDataSource  {

    override fun getFavJobs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getJobs(page: String, pageSize: String, category: String): Observable<JobsRequest> {

        val parameters:MutableMap<String, String> = mutableMapOf()

        parameters.put("start",page)

        parameters.put("length",pageSize)

//        parameters.put("JobCategory",category)

        return jobsService.getJobs(parameters)

    }


    override fun getJob(jobId: String): Single<Job> {

        return jobsService.getJob(jobId)

    }

}