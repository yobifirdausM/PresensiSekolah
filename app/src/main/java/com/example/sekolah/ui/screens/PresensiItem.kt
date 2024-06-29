package com.example.sekolah.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sekolah.model.Presensi

@Composable
fun PresensiItem(item : Presensi) {
    Row {
        Text(modifier = Modifier.weight(3f), text = item.Nama)
        Text(modifier = Modifier.weight(3f), text = item.Kelas)
        Text(modifier = Modifier.weight(3f), text = item.Pelajaran)
        Text(modifier = Modifier.weight(3f), text = item.Keterangan)

    }
}