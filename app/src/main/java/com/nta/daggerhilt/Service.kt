package com.nta.daggerhilt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.nta.daggerhilt.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint // use this due to Service is android component
class Service : Service() {

    @Inject
    lateinit var repository: MyRepository

    override fun onCreate() {
        super.onCreate()

//        repository.doNetworkCall()
    }

    //add ddg
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}