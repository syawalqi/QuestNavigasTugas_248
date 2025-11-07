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