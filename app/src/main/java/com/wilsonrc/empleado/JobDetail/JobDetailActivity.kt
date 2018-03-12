package com.wilsonrc.empleado.JobDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wilsonrc.empleado.R
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebView
import android.webkit.WebResourceRequest
import android.os.Build
import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.view.View
import android.webkit.WebViewClient
import com.bumptech.glide.Glide
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.utils.ActivityUtils

import kotlinx.android.synthetic.main.activity_job_detail.*
import android.net.Uri.fromParts
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class JobDetailActivity : AppCompatActivity() , JobDetailContract.View {

    lateinit var job : Job

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.new_game -> {
                shareJobOffer(job)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.job_detail_menu, menu)
        return true
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
        job = intent.extras.getParcelable<Job>("JobObject")
        val presenter = JobDetailPresenter()
        presenter.attach(this)
        presenter.setJobDetail(job)
    }

    override fun showJobDetail(job: Job) {
        with(job){
            textTitle.text = title
            textCategory.text = categoryName
            textCompanyName.text = companyName
            textCompanyNameAbout.text = companyName
            textCompanyLocation.text = locationName
            textDescription.text = description
            textPublishedDate.text = publishedDate
            textCompanyEmail.text =companyEmail
            textHowApply.text = howToApply

            buttonApplyNow.setOnClickListener{
                applyNow(job)
            }

            Glide.with(this@JobDetailActivity).load(companyLogoUrl).into(imageViewCompanyLogo)
            if(isRemote != null && isRemote as Boolean){
                textRemote.visibility = View.VISIBLE
            }else{
                textRemote.visibility = View.GONE
            }
        }
    }

    private fun applyNow(job: Job){
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", job.companyEmail, null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, job.title)
        startActivity(Intent.createChooser(emailIntent, "Send your Application"))
    }
    private fun shareJobOffer(job: Job){
        val shareBody = "${job.title}: \\n ${job.description} \\n\\n ${job.howToApply} \\n Company Info: *${job.companyName} \\n *${job.companyEmail} \\n ${job.companyUrl}"
        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, job.title)
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share this offer"))
    }


}
