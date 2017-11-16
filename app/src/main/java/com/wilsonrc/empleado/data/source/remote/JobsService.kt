package com.wilsonrc.empleado.data.source.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.utils.LoggingInterceptor
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import okhttp3.OkHttpClient




interface JobsService {

    companion object {
        fun create() : JobsService {

            val client = OkHttpClient.Builder().addInterceptor(LoggingInterceptor()).build()

            val BASE_URL = "https://api.digidev.do/empleado/"

            val retrofit = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(JobsService::class.java)

        }
    }

    @GET("empleos.json")
    fun getJobs(@QueryMap options: Map<String, String>) : Observable<ArrayList<Job>>

    @GET("")
    fun getJob( @Query("JobId") jobId: String) : Single<Job>

}