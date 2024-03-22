package com.nafi.avengerlist.presentation.avengerlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nafi.avengerlist.data.datasource.AvengerDataSource
import com.nafi.avengerlist.data.datasource.AvengerDataSourceImpl

class AvengersListViewModel : ViewModel() {

    private val dataSource: AvengerDataSource by lazy {
        AvengerDataSourceImpl()
    }

    private val _isUsingGridMode = MutableLiveData(false)
    val isUsingGridMode: LiveData<Boolean>
        get() = _isUsingGridMode

    fun changeListMode(){
        val currentValue = _isUsingGridMode.value ?: false
        _isUsingGridMode.postValue(!currentValue)
    }

    fun getAvengersList() = dataSource.getAvengerMembers()
    //Testing Push
}