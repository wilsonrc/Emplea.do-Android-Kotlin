package com.wilsonrc.empleado.jobs


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.models.Job

class JobListFragment : Fragment() , JobsContract.View {

    lateinit var mRecyclerView : RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView : View = inflater.inflate(R.layout.fragment_job_list, container, false);

        mRecyclerView = rootView.findViewById(R.id.rv_jobs)

        val linearLayoutManager  = LinearLayoutManager(context)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        mRecyclerView.layoutManager = linearLayoutManager

      //  mRecyclerView.adapter = mAdapter

        presenter.loadJobs()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        fun newInstance() = JobListFragment()
    }

    override var presenter: JobsContract.Presenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun showJobs(jobs: List<Job>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoJobs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
