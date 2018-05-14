package com.wilsonrc.empleado.JobDetail

import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.di.ActivityScope
import javax.inject.Inject

/**
 * Created by Wilson Reyes on 3/9/2018.
 */
@ActivityScope
class JobDetailPresenter @Inject constructor(): JobDetailContract.Presenter {


    private lateinit var mJobDetailView: JobDetailContract.View

    override fun attach(view: JobDetailContract.View) {
        mJobDetailView = view
    }

    override fun detach() {

    }

    override fun setJobDetail(job: Job) {
        mJobDetailView.showJobDetail(job)
    }
}