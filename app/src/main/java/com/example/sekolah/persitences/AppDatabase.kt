package com.example.sekolah.persitences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sekolah.model.Presensi


@Database(entities = [Presensi::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun presensiDao(): PresensiDao

    companion object{
        const val DATABASE_NAME= "sekolah-database"
    }
}