package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class JobsPresenter(private val jobsRepository: JobsRepository, private val jobCategoryRepository: JobCategoryRepository) : JobsContract.Presenter {

    private lateinit var mJobsView: JobsContract.View

    override fun attach(view: JobsContract.View) {
        mJobsView = view
    }

    override fun detach() {
        disposable?.dispose()
    }

    private var disposable: Disposable? = null


    override fun loadJobs(page: String, category: String) {

        disposable = jobsRepository.getJobs(page = page, category = category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    it.data
                }.doOnError {
                  t ->  t.printStackTrace()
                 }
                .onErrorReturn {
                 emptyList()
                }
                .subscribe(
                        { result ->
                            run {
                                mJobsView.showProgressBar()
                                if (result != null && result.isNotEmpty()) {
                                    mJobsView.showJobs(result)
                                }else{
                                    mJobsView.showNoJobs()
                                }
                            }
                        },
                        { mJobsView.showNoJobs() }
                )
    }

    override fun loadJobCategories() {
        disposable = jobCategoryRepository.getJobCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result -> mJobsView.showJobCategories(result) })
    }


}