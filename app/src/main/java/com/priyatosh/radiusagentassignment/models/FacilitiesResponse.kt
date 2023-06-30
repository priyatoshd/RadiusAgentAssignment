package com.priyatosh.radiusagentassignment.models

data class FacilitiesResponse(
    val exclusions: List<List<Exclusion>>,
    val facilities: List<Facility>
)