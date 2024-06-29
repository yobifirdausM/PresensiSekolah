package com.example.sekolah.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import com.example.sekolah.model.Presensi
import com.example.sekolah.persitences.PresensiDao
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun ListFormScreen(presensiDao: PresensiDao) {

    val _list: LiveData<List<Presensi>> = presensiDao.loadAll()
    val list: List<Presensi> by _list.observeAsState(listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn (modifier = Modifier.fillMaxWidth()){
            items (list.size) {  index->
                val item = list[index]
                PresensiItem(item = item)
            }
        }
    }
}