package com.android.quantum.notasmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.quantum.notasmvvm.models.Nota
import com.android.quantum.notasmvvm.persistance.NotaDao
import com.android.quantum.notasmvvm.persistance.NotaDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NotaRepository private constructor(private val notaDao: NotaDao) {

    suspend fun insertarNota(nota: Nota) = notaDao.insertar(nota)

    suspend fun actualizarNota(nota: Nota) = notaDao.actualizar(nota)

    suspend fun eliminarNota(nota: Nota) = notaDao.eliminar(nota)

    suspend fun eliminarNotas() = notaDao.eliminarNotas()

    suspend fun mostrarNotas(): MutableLiveData<List<Nota>> = notaDao.mostrarListaNotas()

    companion object {

        @Volatile private var instance: NotaRepository? = null
        private val LOCK = Any()

        operator fun invoke(notaDao: NotaDao) = instance ?: synchronized(LOCK){
            instance ?: NotaRepository(notaDao).also {
                instance = it
            }
        }
    }



}