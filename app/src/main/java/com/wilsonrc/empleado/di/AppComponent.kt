package com.wilsonrc.empleado.di

import android.app.Application
import com.wilsonrc.empleado.BaseApp
import com.wilsonrc.empleado.JobDetail.JobDetailActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Wilson Reyes on 5/9/2018.
 */
@Singleton
@Component(modules = arrayOf(
        AppBinding::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ApiServiceModule::class,
        RepositoryModule::class,
        DataSourcesModule::class
))
interface AppComponent : AndroidInjector<BaseApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): Builder

        fun build(): AppComponent
    }


}