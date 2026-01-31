package com.emmaxtech.weightchecker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState 
import androidx.compose.ui.modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModel.compose.viewmodel
import com.emmaxtech.weightchecker.viewmodel.WeightViewModel

@Composable
fun WeightInputScreen(viewModel: WeightViewModel = viewModel()) {
  val weight = viewModel.weight.collectAsState()

  Scaffold(
    topBar = {
       TopAppBar (title = { Text("Weight Checker") })
       }
    ) paddingValues ->
  Column(
    modifier = Modifier
    .padding(paddingValues)
    .padding(16.dp)
) {

    OutlinedTextField(
    value = weight.value,
    onValueChange = { viewModel.onWeightChanged(it) },
      label = { Text("Type in your weight kg") },
      singleLine = true,
       modifier = Modifier.fillMaxWidth()
       )
    Spacer(modifier = Modifier.height(16.dp))
    Button(
      onClick = { viewModel.saveWeight() },
      modifier = modifier.fillMaxWidth()
      ) {
      Text("Save Weight")
    }
  }
}
}

