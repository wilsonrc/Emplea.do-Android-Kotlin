package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.BasePresenter
import com.wilsonrc.empleado.BaseView
import com.wilsonrc.empleado.data.source.models.Job

interface JobsContract {

    interface View : BaseView<Presenter> {

        fun showJobs(jobs: List<Job>)

        fun showNoJobs()

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter : BasePresenter {

        fun loadJobs()

    }

}