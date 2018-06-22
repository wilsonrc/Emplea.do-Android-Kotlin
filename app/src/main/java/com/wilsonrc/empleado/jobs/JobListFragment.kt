package com.wilsonrc.empleado.jobs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout

import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import com.wilsonrc.empleado.data.models.Job
import com.wilsonrc.empleado.data.models.JobCategory
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobCategoryService
import com.wilsonrc.empleado.di.ActivityScope
import com.wilsonrc.empleado.utils.InfiniteScrollListener
import dagger.android.AndroidInjection

import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_job_list.*
import javax.inject.Inject

@ActivityScope
class JobListFragment @Inject constructor(): DaggerFragment() , JobsContract.View {

    @Inject
    lateinit var presenter: JobsContract.Presenter

    private var mAdapter : JobsListAdapter? = null

    private val INITIAL_PAGE = "0"

    private var mPage : Int = 1

    private var mSelectedCategory : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.attach(this)
       return inflater.inflate(R.layout.fragment_job_list, container, false)
    }

    private lateinit var mLinealLayout: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = JobsListAdapter(ArrayList(), context)

        mLinealLayout = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        rv_jobs.layoutManager = mLinealLayout

        rv_jobs.adapter = mAdapter

        swipeContainer.setOnRefreshListener{
            mAdapter?.reset()
            presenter.loadJobs(INITIAL_PAGE, mSelectedCategory)
        }

        presenter.loadJobs(getCurrentPage(), mSelectedCategory)

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_blue_dark)

    }

    private fun getCurrentPage() : String{
        return mPage.toString()
    }

    companion object {
        fun newInstance() = JobListFragment()
    }

    override fun showJobs(jobs: List<Job>) {

        main_container.visibility = View.VISIBLE
        no_jobs_container.visibility = View.GONE

        hideProgressBar()

        mAdapter?.setJobs(jobs)

        swipeContainer.isRefreshing = false

        rv_jobs.clearOnScrollListeners()

        val start = mPage * 10

        rv_jobs.addOnScrollListener(InfiniteScrollListener({ presenter.loadJobs(start.toString(), mSelectedCategory) },mLinealLayout))

        mPage++

    }

    override fun showJobCategories(categories: List<JobCategory>) {

    }

    override fun showNoJobs() {
        main_container?.visibility = View.GONE
        no_jobs_container?.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        progressBarJobListing?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBarJobListing?.visibility = View.GONE
    }


}
