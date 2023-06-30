package com.priyatosh.radiusagentassignment.api

import com.priyatosh.radiusagentassignment.models.FacilitiesResponse
import retrofit2.Response
import retrofit2.http.GET

interface FacilitiesService {

    @GET("/iranjith4/ad-assignment/db")
    suspend fun getFacilities(): Response<FacilitiesResponse>

}