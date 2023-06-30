package com.priyatosh.radiusagentassignment.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyatosh.radiusagentassignment.models.FacilitiesResponse
import com.priyatosh.radiusagentassignment.repository.FacilitiesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(private val repository: FacilitiesRepository): ViewModel() {

    private val _facilities = mutableStateOf(FacilitiesResponse(listOf(), listOf()))
    val facilities: State<FacilitiesResponse> = _facilities

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _facilities.value = repository.getFacilities() ?: FacilitiesResponse(listOf(), listOf())
        }
    }

}

