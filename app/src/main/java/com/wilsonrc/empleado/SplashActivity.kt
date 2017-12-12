package com.wilsonrc.empleado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wilsonrc.empleado.jobs.JobsActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, JobsActivity::class.java))
        finish()
    }
}
