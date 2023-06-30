package com.priyatosh.radiusagentassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.priyatosh.radiusagentassignment.repository.FacilitiesRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: FacilitiesRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}