package com.wilsonrc.empleado.jobs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.models.Job
import kotlinx.android.synthetic.main.fragment_job_list.*

class JobListFragment : Fragment() , JobsContract.View {

    override lateinit var presenter: JobsContract.Presenter

    private var mAdapter : JobsListAdapter? = null

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       return inflater.inflate(R.layout.fragment_job_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = JobsListAdapter(ArrayList<Job>())

        rv_jobs.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        rv_jobs.adapter = mAdapter
    }

    companion object {
        fun newInstance() = JobListFragment()
    }

    override fun showJobs(jobs: ArrayList<Job>) {

        mAdapter?.setJobs(jobs)

        mAdapter?.notifyDataSetChanged()

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
