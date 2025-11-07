package com.example.questnavigastugas_248.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_248.R


@Composable
fun WelcomeScreen(
    onMulaiClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Selamat Datang",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5E35B1),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))


            Image(
                painter = painterResource(id = R.drawable.picture1),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )


            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = "Galih Maulana Syawalqi",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )


            Text(
                text = "20230140248",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = onMulaiClick,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Submit",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}
