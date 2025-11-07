package com.example.questnavigastugas_248.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    onMulaiClick: () -> Unit // callback to go to FormIsian
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF7E57C2)), // purple background
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Selamat Datang!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tekan tombol di bawah untuk memulai",
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(40.dp))