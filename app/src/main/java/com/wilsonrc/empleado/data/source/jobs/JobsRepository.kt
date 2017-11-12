package com.wilsonrc.empleado.data.source.jobs

import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import io.reactivex.Observable
import io.reactivex.Single

class JobsRepository(val jobsRemoteDataSource: JobsRemoteDataSource) : JobsDataSource {

    override fun getJobs(): Observable<List<Job>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJob(jobId: String): Single<Job> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}