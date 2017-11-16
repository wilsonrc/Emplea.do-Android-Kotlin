package com.wilsonrc.empleado.data.source.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wilsonrc.empleado.data.source.models.JobCategory
import com.wilsonrc.empleado.utils.LoggingInterceptor
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JobCategoryService {

    companion object {

        fun create() : JobCategoryService {

            val client = OkHttpClient.Builder().addInterceptor(LoggingInterceptor()).build()

            val BASE_URL = "https://api.myjson.com/bins/"

            val retrofit = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()

            return retrofit.create(JobCategoryService::class.java)

        }
    }

    @GET("t5y4j")
    fun getJobCategories() : Single<ArrayList<JobCategory>>

}