@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.pertemuan6.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan6.R

@Composable
fun TampilData(
    nama: String,
    gender: String,
    alamat: String,
    onBackBtnClick: () -> Unit
){
    val items = listOf(
        "Nama Lengkap" to nama,
        "Jenis Kelamin" to gender,
        "Alamat" to alamat
    )