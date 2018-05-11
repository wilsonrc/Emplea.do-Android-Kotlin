package com.wilsonrc.empleado.di

import android.content.Context
import com.wilsonrc.empleado.BaseApp
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Wilson Reyes on 5/9/2018.
 */
@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract internal fun provideContext(app: BaseApp) : Context


}