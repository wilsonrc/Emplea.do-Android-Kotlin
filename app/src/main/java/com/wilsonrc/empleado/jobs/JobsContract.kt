package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.BasePresenter
import com.wilsonrc.empleado.BaseView
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.data.source.models.JobCategory

interface JobsContract {

    interface View : BaseView<Presenter> {

        fun showJobs(jobs: ArrayList<Job>)

        fun showNoJobs()

        fun showProgressBar()

        fun hideProgressBar()

        fun showJobCategories(categories : ArrayList<JobCategory>)

    }

    interface Presenter : BasePresenter {

        fun loadJobs(page : String , category : String)

        fun loadJobCategories()

    }

}