package com.wilsonrc.empleado.JobDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wilsonrc.empleado.R
import android.content.Intent
import android.net.Uri
import android.os.PersistableBundle
import android.view.View
import com.bumptech.glide.Glide
import com.wilsonrc.empleado.data.models.Job

import kotlinx.android.synthetic.main.activity_job_detail.*
import android.view.Menu
import android.view.MenuItem
import com.wilsonrc.empleado.di.ActivityScope
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.DaggerApplication
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class JobDetailActivity @Inject constructor(): DaggerAppCompatActivity() , JobDetailContract.View {

    @Inject
    lateinit var presenter: JobDetailContract.Presenter

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
        presenter.attach(this)
        presenter.setJobDetail(job)
    }

    override fun showJobDetail(job: Job) {
        with(job){
            textTitle.text = title
            textCategory.text = categoryName
            textCompanyName.text = companyName
            textCompanyNameAbout.text = companyName
            if(locationName.isNullOrBlank()){
                textCompanyLocation.visibility = View.GONE
            }else{
                textCompanyLocation.text = locationName
            }
            textDescription.text = description
            textPublishedDate.text = publishedDate
            textCompanyEmail.text =companyEmail
            textHowApply.text = howToApply

            buttonApplyNow.setOnClickListener{
                applyNow(job)
            }

            if(companyLogoUrl.isNullOrBlank()){
                imageViewCompanyLogo.visibility = View.GONE
            }else{
                Glide.with(this@JobDetailActivity).load(companyLogoUrl).into(imageViewCompanyLogo)
            }
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
        val shareBody = "${job.title ?: ""}: \n ${job.description ?: ""} \n\n ${job.howToApply ?: ""} \n Company Info: \n *${job.companyName ?: ""} \n *${job.companyEmail ?: ""} \n ${job.companyUrl ?: ""}"
        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, job.title)
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share this offer"))
    }


}
