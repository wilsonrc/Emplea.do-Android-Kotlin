package com.wilsonrc.empleado.data.source.jobs

import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobsRequest
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single

class JobsRepository(private val jobsRemoteDataSource: JobsRemoteDataSource) : JobsDataSource {


    override fun getJobs(page: String, pageSize: String, category: String): Observable<JobsRequest> {

       return  jobsRemoteDataSource.getJobs(page,pageSize,category)

    }

    override fun getJob(jobId: String): Single<Job> {

        return jobsRemoteDataSource.getJob(jobId)
    }

    override fun getFavJobs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}