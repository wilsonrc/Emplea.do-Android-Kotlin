package com.wilsonrc.empleado.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wilsonrc.empleado.data.source.remote.JobCategoryService
import com.wilsonrc.empleado.data.source.remote.JobsService
import com.wilsonrc.empleado.utils.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Wilson Reyes on 5/10/2018.
 */
@Module
object ApiServiceModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobsService(retrofit: Retrofit) : JobsService {
        return retrofit.create(JobsService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobCategory() : JobCategoryService{

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