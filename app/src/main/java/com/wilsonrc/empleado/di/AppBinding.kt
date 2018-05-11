package com.wilsonrc.empleado.di

import com.wilsonrc.empleado.jobs.JobsActivity
import com.wilsonrc.empleado.jobs.JobsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Wilson Reyes on 5/11/2018.
 */
@Module
abstract class AppBinding {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(JobsActivityModule::class))
    abstract fun provideJobsActivity() : JobsActivity

}