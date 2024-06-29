package com.example.sekolah.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.sekolah.persitences.AppDatabase


@Composable
fun ScreenPresensi() {
    val context = LocalContext.current

    val db = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    val presensiDao = db.presensiDao()

    Column (modifier = Modifier.fillMaxWidth()) {
        FromScreen(presensiDao)

        ListFormScreen(presensiDao)
    }

}