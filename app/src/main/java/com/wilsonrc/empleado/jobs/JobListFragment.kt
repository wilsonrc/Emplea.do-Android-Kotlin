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
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.data.source.models.JobCategory
import com.wilsonrc.empleado.utils.InfiniteScrollListener
import kotlinx.android.synthetic.main.fragment_job_list.*

class JobListFragment : Fragment() , JobsContract.View {

    override lateinit var presenter: JobsContract.Presenter

    private var mAdapter : JobsListAdapter? = null

    private var mPage : Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       return inflater.inflate(R.layout.fragment_job_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = JobsListAdapter(ArrayList())

        val linealLayout = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        rv_jobs.layoutManager = linealLayout

        rv_jobs.clearOnScrollListeners()

        rv_jobs.addOnScrollListener(InfiniteScrollListener({ presenter.loadJobs(mPage.toString())},linealLayout))

        rv_jobs.adapter = mAdapter

        presenter?.loadJobs(mPage.toString())

        presenter?.loadJobCategories()

    }

    companion object {
        fun newInstance() = JobListFragment()
    }

    override fun showJobs(jobs: ArrayList<Job>) {

        mAdapter?.setJobs(jobs)

        mAdapter?.notifyDataSetChanged()

        mPage++

    }

    override fun showJobCategories(categories: ArrayList<String>) {
        var adapter = ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, categories)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerJobCategory.adapter = adapter

        spinnerJobCategory.onItemSelectedListener = (object: AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

        })
    }

    override fun showNoJobs() {
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
