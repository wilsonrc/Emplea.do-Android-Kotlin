package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers



class JobsPresenter(val jobsRepository: JobsRepository, val jobsView: JobsContract.View) : JobsContract.Presenter {

    private var disposable: Disposable? = null

    override fun start() {

       loadJobs()

    }

    override fun loadJobs() {

        disposable = jobsRepository.getJobs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> jobsView.showJobs(result)},
                        { jobsView.showNoJobs()}
                )

    }
}