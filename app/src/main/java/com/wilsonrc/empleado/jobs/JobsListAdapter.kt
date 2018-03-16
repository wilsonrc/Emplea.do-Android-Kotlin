package com.wilsonrc.empleado.jobs

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.wilsonrc.empleado.JobDetail.JobDetailActivity
import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.models.Job
import kotlinx.android.synthetic.main.item_job.view.*

class JobsListAdapter(private val jobList: MutableList<Job>, private val context: Context?) :
        RecyclerView.Adapter<JobsListAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindJob(jobList[position], context)

    }

    fun reset() {
        jobList.clear()
        notifyDataSetChanged()
    }

    fun setJobs(jobs: List<Job>) {
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
        return jobList.size
    }

    class ViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bindJob(job: Job, context : Context?) {
            with(job) {
                itemView.text_view_company_name.text = companyName
                itemView.text_view_company_location.text = locationName
                itemView.text_view_job_tag.text = categoryName
                if (isRemote != null && isRemote as Boolean) {
                    itemView.text_view_job_remote.visibility = View.VISIBLE
                } else {
                    itemView.text_view_job_remote.visibility = View.GONE
                }
                if(context!=null)
                     Glide.with(context).load(companyLogoUrl).into(itemView.image_view_company_logo)
                itemView.text_view_visits.text = java.lang.String.format(itemView.text_view_visits.text.toString(), viewCount.toString())
                itemView.text_view_job_title.text = title
                itemView.text_view_job_publication_date.text = publishedDate
                itemView.text_view_company_email.text = companyEmail
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, JobDetailActivity::class.java)
                    intent.putExtra("JobObject", job)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}