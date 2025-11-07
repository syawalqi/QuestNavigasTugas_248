@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.questnavigastugas_248.view

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.questnavigastugas_248.R

@Composable
fun FormIsian(
    navController: NavController,
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: (String, String, String) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Formulir Pendaftaran",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Isi Data Diri Anda",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5E35B1)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nama Lengkap
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(text = "Nama Lengkap") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Jenis Kelamin
            Text(
                text = "Jenis Kelamin",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (gender == item),
                            onClick = { gender = item },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorResource(id = R.color.purple_500)
                            )
                        )
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Alamat
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(text = "Alamat") },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Tombol Submit
            Button(
                onClick = { OnSubmitBtnClick(nama, gender, alamat) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = nama.isNotEmpty() && alamat.isNotEmpty() && gender.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Submit", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tombol Kembali
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = colorResource(id = R.color.purple_500)
                )
            ) {
                Text(text = "Kembali ke Beranda", fontSize = 16.sp)
            }
        }
    }
}
