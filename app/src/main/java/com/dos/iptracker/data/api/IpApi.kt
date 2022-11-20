package com.dos.iptracker.data.api

import com.dos.iptracker.domain.entities.IpAddressItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IpApi {
    @GET("json/{ip}")
    suspend fun findIpAddress(@Path("ip") ipAddress: String): Response<IpAddressItem>
}