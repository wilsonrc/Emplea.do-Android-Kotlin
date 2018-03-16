package com.wilsonrc.empleado.JobDetail

import com.wilsonrc.empleado.BasePresenter
import com.wilsonrc.empleado.BaseView
import com.wilsonrc.empleado.data.models.Job

/**
 * Created by Wilson Reyes on 3/9/2018.
 */
interface JobDetailContract {


    interface View : BaseView<Presenter> {

        fun showJobDetail(job : Job)

        fun showProgressBar()

        fun hideProgressBar()

    }

    interface Presenter : BasePresenter<View> {

        fun setJobDetail(job: Job)

    }
}