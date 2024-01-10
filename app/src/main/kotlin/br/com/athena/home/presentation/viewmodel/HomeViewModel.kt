package br.com.athena.home.presentation.viewmodel

import androidx.compose.material.DrawerValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {
    private val _navigationDrawerState = mutableStateOf(DrawerValue.Closed)
    val navigationDrawerState = _navigationDrawerState.value

    fun changeDrawerState(state: Boolean) {
        if (state)
            _navigationDrawerState.value = DrawerValue.Open
        else
            _navigationDrawerState.value = DrawerValue.Closed
    }

}