package com.pieterv.chipping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pieterv.chipping.ui.theme.ChippingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChippingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        FlowFilter(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowFilter(modifier: Modifier) {
    var oneSelected by remember { mutableStateOf(false) }
    var twoSelected by remember { mutableStateOf(false) }
    var threeSelected by remember { mutableStateOf(false) }

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = oneSelected,
            onClick = { oneSelected = !oneSelected },
            label = { Text("Filter Chip one") }
        )
        FilterChip(
            selected = twoSelected,
            onClick = { twoSelected = !twoSelected },
            label = { Text("Filter Chip two") }
        )
        FilterChip(
            selected = threeSelected,
            onClick = { threeSelected = !threeSelected },
            label = { Text("Filter Chip three") }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipRow(modifier: Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AssistChip(
            onClick = { },
            label = { Text("Assist Chip") }
        )
        FilterChip(
            selected = true,
            onClick = { },
            label = { Text("Filter Chip") }
        )
        InputChip(
            selected = false,
            onClick = { },
            label = { Text("Input Chip") }
        )
        SuggestionChip(
            onClick = { },
            label = { Text("Suggestion Chip") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChipRowPreview() {
    ChippingTheme {
        ChipRow(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlowFilterPreview() {
    ChippingTheme {
        FlowFilter(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}