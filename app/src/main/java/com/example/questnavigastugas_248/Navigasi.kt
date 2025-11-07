package com.example.questnavigastugas_248

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.questnavigastugas_248.view.TampilData
import com.example.questnavigastugas_248.view.FormIsian
import com.example.questnavigastugas_248.view.WelcomeScreen

enum class Navigasi {
    Welcome,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Welcome.name, // halaman pertama = Welcome
            modifier = Modifier.padding(isiRuang)
        ) {

            composable(route = Navigasi.Welcome.name) {
                WelcomeScreen(
                    onMulaiClick = {
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }


            composable(route = Navigasi.Formulir.name) {
                FormIsian(
                    navController = navController,
                    OnSubmitBtnClick = { nama, gender, alamat ->
                        navController.navigate(
                            "${Navigasi.Detail.name}/$nama/$gender/$alamat"
                        )
                    }
                )
            }


            composable(
                route = "${Navigasi.Detail.name}/{nama}/{gender}/{alamat}"
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val gender = backStackEntry.arguments?.getString("gender") ?: ""
                val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                TampilData(
                    nama = nama,
                    gender = gender,
                    alamat = alamat,
                    onBackBtnClick = { navController.popBackStack() },
                    navController = navController
                )
            }
        }
    }
}
