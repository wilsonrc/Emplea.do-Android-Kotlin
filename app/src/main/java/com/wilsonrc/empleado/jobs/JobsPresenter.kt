package com.wilsonrc.empleado.jobs

import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import com.wilsonrc.empleado.data.source.models.JobCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers



class JobsPresenter(private val jobsRepository: JobsRepository, private val jobCategoryRepository: JobCategoryRepository ,private val jobsView: JobsContract.View) : JobsContract.Presenter {

    private var disposable: Disposable? = null

    override fun start() {

    }

    override fun loadJobs(page: String) {

        disposable = jobsRepository.getJobs(page = page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> jobsView.showJobs(result)},
                        { jobsView.showNoJobs()}
                )
    }

    override fun loadJobCategories() {
        disposable = jobCategoryRepository.getJobCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map{
                    var categories: ArrayList<String> = ArrayList()
                    for(category in it){
                        category.name?.let { categoryName -> categories.add(categoryName) }
                    }
                    categories
                }
                .subscribe({result -> jobsView.showJobCategories(result)})
    }

}