package com.nta.daggerhilt.data.repository

import android.content.Context
import com.nta.daggerhilt.R
import com.nta.daggerhilt.data.remote.MyApi
import com.nta.daggerhilt.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Context // only when need app context
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository! The app name is $appName")
    }

    override suspend fun doNetworkCall() {
    }

}