package com.dos.iptracker.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dos.iptracker.domain.entities.IpAddressItem
import com.dos.iptracker.domain.respositories.IpApiRepository
import com.dos.iptracker.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(val ipApiRepository: IpApiRepository): ViewModel() {
    private val ipInfoLiveData = MutableLiveData<Resource<IpAddressItem>>()
    fun getIpInfo() = ipInfoLiveData
    fun getIpItemInfo(ip: String){
        viewModelScope.launch {
            ipInfoLiveData.value = Resource.Loading
            val ipInfo = ipApiRepository.getIpItemInfo(ip)
            ipInfoLiveData.value = ipInfo
        }
    }

}