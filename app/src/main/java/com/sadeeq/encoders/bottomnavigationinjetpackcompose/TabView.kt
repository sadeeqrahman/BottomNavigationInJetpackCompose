package com.sadeeq.encoders.bottomnavigationinjetpackcompose

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun TabView(
    tabBarItems: List<TabBarItem>,
    navController: NavController,
    badgeViewModel: BadgeViewModel
) {

    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(
        contentColor = Color.Red,
        containerColor = Color.White,
        tonalElevation = 10.dp,
        modifier = Modifier
            .border(
                width = 1.dp, color = Color.LightGray, RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp
                )
            )

    ) {
        // looping over each tab to generate the views and navigation for each item
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red,
                    selectedTextColor = Color.Red,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                ),
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    TabBarIconView(
                        isSelected = selectedTabIndex == index,
                        selectedIcon = tabBarItem.selectedIcon,
                        unselectedIcon = tabBarItem.unselectedIcon,
                        title = tabBarItem.title,
                        badgeAmount = badgeViewModel.badgeAmountMap.value[tabBarItem.title]
                    )
                },

                label = { Text(tabBarItem.title) })
        }
    }
}
