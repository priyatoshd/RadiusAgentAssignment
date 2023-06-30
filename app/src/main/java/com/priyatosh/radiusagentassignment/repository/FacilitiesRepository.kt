package com.priyatosh.radiusagentassignment.repository

import com.priyatosh.radiusagentassignment.api.FacilitiesService
import com.priyatosh.radiusagentassignment.models.FacilitiesResponse
import javax.inject.Inject

class FacilitiesRepository @Inject constructor(private val facilitiesService: FacilitiesService) {

    suspend fun getFacilities(): FacilitiesResponse? {

        val response = facilitiesService.getFacilities()
        return if (response.isSuccessful && response.body() != null) {
            response.body()
        } else {
            null
        }
    }
}