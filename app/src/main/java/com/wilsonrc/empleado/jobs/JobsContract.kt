package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.BasePresenter
import com.wilsonrc.empleado.BaseView
import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobCategory

interface JobsContract {

    interface View : BaseView<Presenter> {

        fun showJobs(jobs: List<Job>)

        fun showNoJobs()

        fun showProgressBar()

        fun hideProgressBar()

        fun showJobCategories(categories : List<JobCategory>)

    }

    interface Presenter : BasePresenter<View>  {

        fun loadJobs(page : String , category : String)

        fun loadJobCategories()

    }

}