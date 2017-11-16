package com.wilsonrc.empleado.jobs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wilsonrc.empleado.R
import com.wilsonrc.empleado.data.source.JobCategory.JobCategoryRepository
import com.wilsonrc.empleado.data.source.jobs.JobsRepository
import com.wilsonrc.empleado.data.source.remote.JobCategoryRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobCategoryService
import com.wilsonrc.empleado.data.source.remote.JobsRemoteDataSource
import com.wilsonrc.empleado.data.source.remote.JobsService
import com.wilsonrc.empleado.utils.ActivityUtils

class JobsActivity : AppCompatActivity(){

    private var mPresenter : JobsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_jobs)

        val listResultFragment = JobListFragment.newInstance()

        mPresenter = JobsPresenter(jobsRepository =  JobsRepository(JobsRemoteDataSource(JobsService.create())),
                jobCategoryRepository = JobCategoryRepository(JobCategoryRemoteDataSource(JobCategoryService.create())) , jobsView =  listResultFragment)

        ActivityUtils.addFragmentToActivity(supportFragmentManager,listResultFragment,R.id.jobs_list_container)

        listResultFragment.presenter = mPresenter as JobsPresenter
    }

}
