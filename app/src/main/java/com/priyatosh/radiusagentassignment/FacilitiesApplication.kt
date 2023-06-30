package com.priyatosh.radiusagentassignment

import android.app.Application
import com.priyatosh.radiusagentassignment.di.ApplicationComponent
import com.priyatosh.radiusagentassignment.di.DaggerApplicationComponent

class FacilitiesApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}