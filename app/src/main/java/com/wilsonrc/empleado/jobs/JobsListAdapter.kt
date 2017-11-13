package com.wilsonrc.empleado.jobs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.models.Job

class JobsListAdapter(private val jobList : List<Job>,
                      private val itemClick: (Job) -> Unit) :
        RecyclerView.Adapter<JobsListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       holder.bindJob(jobList[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_job , parent,false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }


    class ViewHolder(view: View, private val itemClick: (Job) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindJob(job: Job){
            with(job){

            }
        }
    }
}