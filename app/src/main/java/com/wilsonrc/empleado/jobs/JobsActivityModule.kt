package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import com.wilsonrc.empleado.di.ActivityScope
import com.wilsonrc.empleado.di.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wilson Reyes on 5/11/2018.
 */

@Module
abstract class JobsActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideJobListFragment() : JobListFragment

    @Binds
    @ActivityScope
    abstract internal fun provideJobsPresenter(jobsPresenter: JobsPresenter) : JobsContract.Presenter

}