package com.example.sekolah.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.benasher44.uuid.uuid4
import com.example.sekolah.model.Presensi
import com.example.sekolah.persitences.PresensiDao
import kotlinx.coroutines.launch


@Composable
fun FromScreen(presensiDao: PresensiDao) {
    val scope = rememberCoroutineScope()

    val Nama = remember{ mutableStateOf(TextFieldValue("")) }
    val Kelas = remember{ mutableStateOf(TextFieldValue("")) }
    val Pelajaran = remember{ mutableStateOf(TextFieldValue("")) }
    val Keterangan= remember{ mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()){
        OutlinedTextField(
            label = { Text(text ="Nama") },
            modifier = Modifier.fillMaxWidth(),
            value = Nama.value, onValueChange ={
                Nama.value = it
            } )

        OutlinedTextField(
            label = { Text(text ="Kelas") },
            modifier = Modifier.fillMaxWidth(),
            value = Kelas.value, onValueChange ={
                Kelas.value = it
            } )
        OutlinedTextField(
            label = { Text(text ="Pelajaran") },
            modifier = Modifier.fillMaxWidth(),
            value = Pelajaran.value, onValueChange ={
                Pelajaran.value = it
            } )

        OutlinedTextField(
            label = { Text(text ="Keterangan") },
            modifier = Modifier.fillMaxWidth(),
            value = Keterangan.value, onValueChange ={
                Nama.value = it
            } )

        Row {
            Button(modifier = Modifier.weight(5f), onClick = {
                val item = Presensi(uuid4().toString(), Nama.value.text, Kelas.value.text, Pelajaran.value.text, Keterangan.value.text)
                scope.launch {
                    presensiDao.upsert(item)
                }
                Nama.value = TextFieldValue("")
                Kelas.value = TextFieldValue("")
                Pelajaran.value = TextFieldValue("")
                Keterangan.value = TextFieldValue("")
            }){
                Text(text = "Simpan")
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                Nama.value = TextFieldValue("")
                Kelas.value = TextFieldValue("")
                Pelajaran.value = TextFieldValue("")
                Keterangan.value = TextFieldValue("")

            }){
                Text(text = "Batal")
            }
        }
    }


}