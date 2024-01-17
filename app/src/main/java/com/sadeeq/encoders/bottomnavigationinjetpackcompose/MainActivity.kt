package com.sadeeq.encoders.bottomnavigationinjetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.screens.AlertsScreen
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.screens.HomeScreen
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.screens.MoreScreen
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.screens.SettingsScreen
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.ui.theme.BottomNavigationInJetpackComposeTheme

class MainActivity : ComponentActivity() {
    private val badgeViewModel by viewModels<BadgeViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {



            val homeTab = TabBarItem(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
            val alertsTab = TabBarItem(title = "Alerts", selectedIcon = Icons.Filled.Notifications, unselectedIcon = Icons.Outlined.Notifications)
            val settingsTab = TabBarItem(title = "Settings", selectedIcon = Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings)
            val moreTab = TabBarItem(title = "More", selectedIcon = Icons.Filled.List, unselectedIcon = Icons.Outlined.List)

            // creating a list of all the tabs
            val tabBarItems = listOf(homeTab, alertsTab, settingsTab, moreTab)

            // creating our navController
            val navController = rememberNavController()
            var visible by remember {
                mutableStateOf(true)
            }
            BottomNavigationInJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = { TabView(tabBarItems, navController, badgeViewModel) }) {
                        NavHost(navController = navController, startDestination = homeTab.title) {
                            composable(homeTab.title) {
                                AnimatedVisibility(visible) {
                                    HomeScreen(badgeViewModel = badgeViewModel)
                                }

                            }
                            composable(alertsTab.title) {
                                AnimatedVisibility(visible) {
                                    AlertsScreen(badgeViewModel)
                                }

                            }
                            composable(settingsTab.title) {
                                SettingsScreen(badgeViewModel = badgeViewModel)
                            }
                            composable(moreTab.title) {
                                MoreScreen(badgeViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNavigationInJetpackComposeTheme {

    }
}