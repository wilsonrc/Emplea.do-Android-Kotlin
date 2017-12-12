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
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.data.source.models.JobCategory
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobCategoryService
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobsService
import com.wilsonrc.empleado.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_job_list.*

class JobListFragment : Fragment() , JobsContract.View {


    lateinit var presenter: JobsContract.Presenter

    private var mAdapter : JobsListAdapter? = null

    private var mPage : Int = 1

    private var mSelectedCategory : String = "None"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = JobsPresenter(jobsRepository =  JobsRepository(JobsRemoteDataSource(JobsService.create())),
                jobCategoryRepository = JobCategoryRepository(JobCategoryRemoteDataSource(JobCategoryService.create())))
        presenter.attach(this)
       return inflater.inflate(R.layout.fragment_job_list, container, false)
    }

    private lateinit var mLinealLayout: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = JobsListAdapter(ArrayList())

        mLinealLayout = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        rv_jobs.layoutManager = mLinealLayout

        rv_jobs.adapter = mAdapter

        presenter.loadJobs(mPage.toString(),mSelectedCategory)

        presenter.loadJobCategories()

    }

    companion object {
        fun newInstance() = JobListFragment()
    }

    override fun showJobs(jobs: ArrayList<Job>) {

       hideProgressBar()

        mAdapter?.setJobs(jobs)

        mAdapter?.notifyDataSetChanged()

        rv_jobs.clearOnScrollListeners()

        rv_jobs.addOnScrollListener(InfiniteScrollListener({ presenter.loadJobs(mPage.toString(), mSelectedCategory) },mLinealLayout))

        mPage++

    }

    override fun showJobCategories(categories: ArrayList<JobCategory>) {
        val adapter = ArrayAdapter(context,android.R.layout.simple_spinner_item, categories)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerJobCategory.adapter = adapter

        spinnerJobCategory.onItemSelectedListener = (object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val item = spinnerJobCategory.selectedItem as JobCategory
                if(mSelectedCategory != item.name){
                        mSelectedCategory = item.name.toString()
                        mAdapter?.reset()
                        mPage = 1
                        presenter.loadJobs(mPage.toString(), mSelectedCategory)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        })
    }

    override fun showNoJobs() {
    }

    override fun showProgressBar() {
        progressBarJobListing.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBarJobListing.visibility = View.GONE
    }


}
