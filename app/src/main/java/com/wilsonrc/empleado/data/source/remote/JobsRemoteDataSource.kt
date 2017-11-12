package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.source.jobs.JobsDataSource
import com.wilsonrc.empleado.data.source.models.Job
import io.reactivex.Observable
import io.reactivex.Single


class JobsRemoteDataSource(private val jobsService: JobsService) : JobsDataSource {

    override fun getJobs(): Observable<List<Job>> {
       var map = emptyMap<String, String>()
       return jobsService.getJobs(map);
    }

    override fun getJob(jobId: String): Single<Job> {
        return jobsService.getJob(jobId)
    }

}