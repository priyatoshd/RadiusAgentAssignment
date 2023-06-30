package com.priyatosh.radiusagentassignment.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.priyatosh.radiusagentassignment.models.FacilitiesResponse
import com.priyatosh.radiusagentassignment.models.Facility
import com.priyatosh.radiusagentassignment.models.Option
import com.priyatosh.radiusagentassignment.ui.theme.RadiusAgentAssignmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityScreen(
    response: FacilitiesResponse
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Assignment Application",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
            )
        }

    ) {
        Column(
            Modifier.padding(it)
        ) {
            LazyColumn(
                Modifier.padding(16.dp)
            ) {
                items(response.facilities) { facility ->
                    FacilityWithOptions(facility)
                }
            }
        }
    }

    
}

@Composable
fun FacilityWithOptions(facility: Facility) {
    Column {
        Text(
            text = facility.name,
            style = MaterialTheme.typography.titleMedium
        )
        FacilityOptions(facility.options)
    }

}

@Composable
fun FacilityOptions(options: List<Option>) {
    SimpleRadioButtonComponent(options)
}

@Composable
fun SimpleRadioButtonComponent(
    radioOptions: List<Option>,
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0].id) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LazyRow {
            items(radioOptions) { option ->
                Row(
                    Modifier
                        .selectable(
                            selected = (option.id == selectedOption),
                            onClick = { onOptionSelected(option.id) }
                        )
                ) {
                    RadioButton(
                        selected = (option.id == selectedOption),modifier = Modifier.padding(all = Dp(value = 8F)),
                        onClick = {
                            onOptionSelected(option.id)
                        }
                    )

                    Text(
                        text = option.name,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPrev() {

    RadiusAgentAssignmentTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {

            MainActivityScreen(
                response = FacilitiesResponse(
                    listOf(), listOf(
                        Facility(
                            "1",
                            "Property Type",
                            listOf(
                                Option(
                                    "icon",
                                    "1",
                                    "Apartment"
                                )
                            )
                        )
                    )
                )
            )
        }
    }
    
}