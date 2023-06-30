package com.priyatosh.radiusagentassignment.di

import com.priyatosh.radiusagentassignment.views.MainActivity
import com.priyatosh.radiusagentassignment.viewmodels.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)
}