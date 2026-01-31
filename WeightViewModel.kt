package com.emmaxtech.weightchecker.viewmodel

import androidx.lifecycle.Viewmodel
import androidx.lifecycle.viewModelScope
import com.emmaxtech.weightchecker.data.WeightRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeightViewModel {
priva
  te val repository: WeightRepository = WeightRepository()
) : ViewModel() {

  private val _weight = MutableStateFlow("")
  val weight: StateFlow<String> = _weight

  fun onWeightChanged(newWeight: String) {
    _weight.value = newWeight
  }

  fun saveWeight() {
    val weightValue = _weight.value.toFloatorNull()
    if (weightValue ! = null) {
      viewModelScope.launch {
        repository.saveWeight(weightValue)
      }
    }
  }
}

