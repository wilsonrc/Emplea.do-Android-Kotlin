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

import kotlinx.android.synthetic.main.activity_job_detail.*



class JobDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        jobDetailWebView.settings.loadsImagesAutomatically = true

        jobDetailWebView.settings.javaScriptEnabled = true

        jobDetailWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        jobDetailWebView.webViewClient = MyBrowser()

        intent.extras.get("JOB_URL")?.toString().let {
            jobDetailWebView.loadUrl(it)
        }


    }

    private inner class MyBrowser : WebViewClient() {

        @SuppressWarnings("deprecation")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }
    }

}
