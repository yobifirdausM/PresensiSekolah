package com.example.sekolah.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Presensi(
    @PrimaryKey
    val id : String,
    val Nama : String,
    val Kelas : String,
    val Pelajaran : String,
    val Keterangan : String
)
