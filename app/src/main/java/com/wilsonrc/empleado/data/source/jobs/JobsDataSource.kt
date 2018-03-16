package com.wilsonrc.empleado.data.source.jobs

import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobsRequest
import io.reactivex.Observable
import io.reactivex.Single

interface JobsDataSource {

    fun getJobs(page: String = "1", pageSize: String = "10", category: String = "") : Observable<JobsRequest>

    fun getJob(jobId: String): Single<Job>

    fun getFavJobs()

}