package com.wilsonrc.empleado.JobDetail

import com.wilsonrc.empleado.data.source.models.Job

/**
 * Created by Wilson Reyes on 3/9/2018.
 */
class JobDetailPresenter : JobDetailContract.Presenter {


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