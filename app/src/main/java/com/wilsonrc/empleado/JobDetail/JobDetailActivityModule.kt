package com.wilsonrc.empleado.JobDetail

import com.wilsonrc.empleado.di.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wilson Reyes on 5/11/2018.
 */

@Module
abstract class JobDetailActivityModule {

    @Binds
    @ActivityScope
    abstract internal fun provideJobsPresenter(jobsPresenter: JobDetailPresenter) : JobDetailContract.Presenter

}