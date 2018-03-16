package com.wilsonrc.empleado.data.source.local

import com.wilsonrc.empleado.data.source.jobs.JobsDataSource
import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobsRequest
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Wilson Reyes on 3/16/2018.
 */
class JobsLocalDataSource : JobsDataSource {

    override fun getFavJobs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJobs(page: String, pageSize: String, category: String): Observable<JobsRequest> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJob(jobId: String): Single<Job> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}