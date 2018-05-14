package com.wilsonrc.empleado.di

import android.app.job.JobService
import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryDataSource
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobCategoryService
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobsService
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Wilson Reyes on 5/10/2018.
 */
@Module
object DataSourcesModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobsRemoteDataSource(jobService: JobsService): JobsRemoteDataSource {
        return JobsRemoteDataSource(jobService)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobCategoryRemoteDataSource(jobCategoryService: JobCategoryService): JobCategoryRemoteDataSource{
        return JobCategoryRemoteDataSource(jobCategoryService)
    }

}