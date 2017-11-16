package com.wilsonrc.empleado.data.source.jobs

import com.wilsonrc.empleado.data.source.models.Job
import io.reactivex.Observable
import io.reactivex.Single

interface JobsDataSource {

    fun getJobs(page: String = "1", pageSize: String = "5", category: String = "None") : Observable<ArrayList<Job>>

    fun getJob(jobId: String): Single<Job>

}