package com.example.QuestNavigasiTugas_248






enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ){
            composable(route = Navigasi.Formulir.name) {
                FormIsian(
                    OnSubmitBtnClick = { nama, gender, alamat ->
                        // Navigate to Detail and pass data via route
                        navController.navigate(
                            "${Navigasi.Detail.name}/$nama/$gender/$alamat"
                        )
                    }
                )
            }

            composable(
                route = "${Navigasi.Detail.name}/{nama}/{gender}/{alamat}",
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val gender = backStackEntry.arguments?.getString("gender") ?: ""
                val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                TampilData(
                    nama = nama,
                    gender = gender,
                    alamat = alamat,
                    onBackBtnClick = { navController.popBackStack() }
                )
            }
        }
    }
}