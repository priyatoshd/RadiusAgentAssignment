package com.priyatosh.radiusagentassignment.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.priyatosh.radiusagentassignment.FacilitiesApplication
import com.priyatosh.radiusagentassignment.ui.theme.RadiusAgentAssignmentTheme
import com.priyatosh.radiusagentassignment.ui.theme.screens.MainActivityScreen
import com.priyatosh.radiusagentassignment.viewmodels.MainViewModel
import com.priyatosh.radiusagentassignment.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as FacilitiesApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        setContent {
            RadiusAgentAssignmentTheme {

                val facilities by remember {
                    mainViewModel.facilities
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityScreen(response = facilities)
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RadiusAgentAssignmentTheme {
        Greeting("Android")
    }
}