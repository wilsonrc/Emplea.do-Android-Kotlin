package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.BasePresenter
import com.wilsonrc.empleado.BaseView

interface JobsContract {

    interface View : BaseView<Presenter> {

        fun showJobs()

        fun showNoJobs()

    }

    interface Presenter : BasePresenter {

        fun loadJobs()

    }

}