@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.questnavigastugas_248.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_248.R
import androidx.navigation.NavController

@Composable
fun TampilData(
    nama: String,
    gender: String,
    alamat: String,
    onBackBtnClick: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("List Daftar Peserta", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_200)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Data Boxes
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("NAMA LENGKAP", fontSize = 14.sp, color = Color.Gray)
                    Text(nama, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("JENIS KELAMIN", fontSize = 14.sp, color = Color.Gray)
                    Text(gender, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("STATUS PERKAWINAN", fontSize = 14.sp, color = Color.Gray)
                    Text("Lajang", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("ALAMAT", fontSize = 14.sp, color = Color.Gray)
                    Text(alamat, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))


            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                onClick = {

                    navController.popBackStack(route = "Welcome", inclusive = false)
                }
            ) {
                Text("Beranda")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                onClick = {

                    navController.popBackStack()
                }
            ) {
                Text("Formulir Pendaftaran")
            }
        }
    }
}
