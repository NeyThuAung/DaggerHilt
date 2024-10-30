package com.nta.daggerhilt.domain.repository

interface MyRepository {

    suspend fun doNetworkCall()
}