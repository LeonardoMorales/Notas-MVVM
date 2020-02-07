package com.android.quantum.notasmvvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_notas")
data class Nota(

    @ColumnInfo(name = "titulo")
    var titulo: String,

    @ColumnInfo(name = "descripcion")
    var descripcion: String,

    @ColumnInfo(name = "prioridad")
    var prioridad: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}