package com.portfolio.brimo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.portfolio.brimo.R
import com.portfolio.brimo.data.IconButtonData
import com.portfolio.brimo.ui.theme.BRImoTheme

enum class NavGraph {
    LOGIN,
    DOMPETDIGITAL,
    SETORTUNAI,
    CATATANKEUANGAN,
    BRIZZI,
    PULSADATA,
    QRIS
}

@Composable
fun BRImoApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppBar() }
    ) {
        NavHost(
            navController = navController,
            startDestination = NavGraph.LOGIN.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = NavGraph.LOGIN.name) {
                LoginScreen(
                    dataIconButton = IconButtonData.setLoginIconButton,
                    modifier = Modifier
                        .fillMaxSize(),
                    onClickNav = { navRoute -> navController.navigate(navRoute) }
                )
            }
            composable(route = NavGraph.DOMPETDIGITAL.name) {
                DompetDigitalScreen(
                    dataTopUpButton = IconButtonData.setTopUpIconButton,
                    onClickNav = {})
            }
            composable(route = NavGraph.BRIZZI.name) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = navController.currentDestination.toString())
                }
            }
            composable(route = NavGraph.CATATANKEUANGAN.name) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = navController.currentDestination.toString())
                }
            }
            composable(route = NavGraph.PULSADATA.name) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = navController.currentDestination.toString())
                }
            }
            composable(route = NavGraph.QRIS.name) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = navController.currentDestination.toString())
                }
            }
            composable(route = NavGraph.SETORTUNAI.name) {
                SetorTunaiScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.brimo_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(32.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF21409A))
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BRImoTheme {
        Surface {
            BRImoApp()
        }
    }
}