package com.example.sekolah.persitences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sekolah.model.Presensi

@Dao
interface PresensiDao {
    @Query("select * from Presensi")
    fun loadAll(): LiveData<List<Presensi>>

    @Query("select * from Presensi")
    fun load(id: String): LiveData<Presensi>

    @Query("select * from Presensi where id = id")
    suspend fun getById(id: String): Presensi?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Presensi)

    @Query("delete from Presensi where id = :id")
    suspend fun delete(id: String)

    @Delete
    suspend fun delete(item : Presensi)
}