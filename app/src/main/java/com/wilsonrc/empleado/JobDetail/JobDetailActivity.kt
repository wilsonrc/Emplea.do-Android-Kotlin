package com.wilsonrc.empleado.JobDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wilsonrc.empleado.R
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebView
import android.webkit.WebResourceRequest
import android.os.Build
import android.annotation.TargetApi
import android.view.View
import android.webkit.WebViewClient
import com.bumptech.glide.Glide
import com.wilsonrc.empleado.data.source.models.Job
import com.wilsonrc.empleado.utils.ActivityUtils

import kotlinx.android.synthetic.main.activity_job_detail.*



class JobDetailActivity : AppCompatActivity() , JobDetailContract.View {

    override fun showJobDetail(job: Job) {
        with(job){
            textTitle.text = title
            textCategory.text = categoryName
            textCompanyName.text = companyName
            textCompanyNameAbout.text = companyName
            textDescription.text = description
            textPublishedDate.text = publishedDate
            textCompanyEmail.text =companyEmail
            textHowApply.text = howToApply
            Glide.with(this@JobDetailActivity).load(companyLogoUrl).into(imageViewCompanyLogo)
            if(isRemote != null && isRemote as Boolean){
                textRemote.visibility = View.VISIBLE
            }else{
                textRemote.visibility = View.GONE
            }
        }
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

        val job = intent.extras.getParcelable<Job>("JobObject")
        val presenter = JobDetailPresenter()
        presenter.attach(this)
        presenter.setJobDetail(job)

    }

}
