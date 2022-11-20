package com.dos.iptracker.domain.respositories

import com.dos.iptracker.domain.entities.IpAddressItem
import com.dos.iptracker.utils.Resource

interface IpApiRepository {
    suspend fun getIpItemInfo(ip: String): Resource<IpAddressItem>
}