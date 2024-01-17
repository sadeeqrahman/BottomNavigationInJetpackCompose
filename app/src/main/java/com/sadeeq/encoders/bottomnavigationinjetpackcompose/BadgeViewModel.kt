package com.sadeeq.encoders.bottomnavigationinjetpackcompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BadgeViewModel : ViewModel() {
    val badgeAmountMap: MutableState<Map<String, Int>> = mutableStateOf(emptyMap())

    fun updateBadge(tabId: String, newAmount: Int) {
        val currentMap = badgeAmountMap.value.toMutableMap()
        currentMap[tabId] = newAmount
        badgeAmountMap.value = currentMap
    }
}
