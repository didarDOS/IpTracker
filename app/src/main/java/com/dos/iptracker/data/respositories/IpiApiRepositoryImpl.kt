package com.dos.iptracker.data.respositories

import com.dos.iptracker.data.api.IpApi
import com.dos.iptracker.domain.entities.IpAddressItem
import com.dos.iptracker.domain.respositories.IpApiRepository
import com.dos.iptracker.utils.NetworkExceptions
import com.dos.iptracker.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IpiApiRepositoryImpl(val ipApi: IpApi): IpApiRepository {
    override suspend fun getIpItemInfo(ip: String): Resource<IpAddressItem> = withContext(Dispatchers.IO){
        val result = ipApi.findIpAddress(ip)
        if (result.isSuccessful)
            return@withContext Resource.Success(result.body())
        if (result.code() in 400..600 ) {
            return@withContext Resource.Error(NetworkExceptions.BadRequest())
        }
        Resource.Error(NetworkExceptions.ServiceException())

    }
}