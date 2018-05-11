package com.wilsonrc.empleado

import com.wilsonrc.empleado.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by Wilson Reyes on 5/9/2018.
 */
class BaseApp : DaggerApplication()  {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}