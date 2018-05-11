package com.wilsonrc.empleado.di

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Wilson Reyes on 5/10/2018.
 */
@Module
object RepositoryModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobsRepository(jobsRemoteDataSource: JobsRemoteDataSource) : JobsRepository{
        return JobsRepository(jobsRemoteDataSource)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideJobCategoryRepository(jobCategoryRemoteDataSource: JobCategoryRemoteDataSource) : JobCategoryRepository{
        return JobCategoryRepository(jobCategoryRemoteDataSource)
    }

}