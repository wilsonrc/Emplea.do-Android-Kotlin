package com.wilsonrc.empleado.jobs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.models.Job
import kotlinx.android.synthetic.main.item_job.view.*
import kotlin.collections.ArrayList

class JobsListAdapter(private val jobList: MutableList<Job>) :
        RecyclerView.Adapter<JobsListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindJob( jobList[position])
    }

    fun setJobs(jobs: ArrayList<Job>){
        jobList.addAll(jobs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent?.context).inflate(R.layout.item_job, parent, false)
                .let {
                    ViewHolder(it)
                }
    }

    override fun getItemCount(): Int {
        return jobList?.size
    }

    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bindJob(job: Job){
            with(job){
                itemView.text_view_company_name.text = jobCompany
                itemView.text_view_company_location.text = jobLocation
                itemView.text_view_job_tag.text = jobType
                itemView.text_view_job_title.text = jobTitle
                itemView.text_view_job_publication_date.text = jobDate
            }
        }
    }
}