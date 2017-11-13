package com.wilsonrc.empleado.jobs

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.models.Job
import kotlinx.android.synthetic.main.item_job.view.*
import java.util.ArrayList

class JobsListAdapter :
        RecyclerView.Adapter<JobsListAdapter.ViewHolder>() {

    private var jobList : MutableList<Job> = ArrayList(0)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.companyName.text = jobList[position].jobCompany
    }

    fun setJobs(jobs: ArrayList<Job>){
        jobList.addAll(jobs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_job, parent, false))

    }

    override fun getItemCount(): Int {
        return jobList?.size
    }

    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val companyName = view.text_view_company_name

//        fun bindJob(job: Job){
//            with(job){
//                itemView.text_view_company_name.text = jobCompany
//                itemView.text_view_company_location.text = jobLocation
//                itemView.text_view_job_tag.text = jobType
//                itemView.text_view_job_title.text = jobTitle
//                itemView.text_view_job_publication_date.text = jobDate
//            }
//        }
    }
}