package com.android.quantum.notasmvvm.persistance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.android.quantum.notasmvvm.models.Nota

@Dao
interface NotaDao {

    @Insert
    suspend fun insertar(nota: Nota)

    @Update
    suspend fun actualizar(nota: Nota)

    @Delete
    suspend fun eliminar(nota: Nota)

    @Query("DELETE FROM tabla_notas")
    suspend fun eliminarNotas()

    @Query("SELECT * FROM tabla_notas ORDER BY prioridad DESC")
    suspend fun mostrarListaNotas(): MutableLiveData<List<Nota>>

}