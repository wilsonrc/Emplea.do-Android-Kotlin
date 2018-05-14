package com.wilsonrc.empleado.data.source.remote

import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobCategory
import com.wilsonrc.empleado.data.models.JobsRequest
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface JobsService {

    @GET("jobs")
    fun getJobs(@QueryMap options: Map<String, String>) : Observable<JobsRequest>

    @GET("")
    fun getJob( @Query("JobId") jobId: String) : Single<Job>

    @GET("")
    fun getJobCategories() : Single<ArrayList<JobCategory>>

}