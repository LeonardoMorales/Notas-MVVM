package com.android.quantum.notasmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.quantum.notasmvvm.models.Nota
import com.android.quantum.notasmvvm.repository.NotaRepository
import com.android.quantum.notasmvvm.utils.Coroutines

class MainActivityViewModel(
    val repository: NotaRepository
): ViewModel()
{
    private val _notas = MutableLiveData<List<Nota>>()
    val notas: LiveData<List<Nota>>
        get() = _notas



    fun insertarNota(nota: Nota) {
        Coroutines.main{
            repository.insertarNota(nota)
        }
    }

    fun actualizarNota(nota: Nota) {
        Coroutines.main{
            repository.actualizarNota(nota)
        }
    }

    fun eliminarNota(nota: Nota) {
        Coroutines.main{
            repository.eliminarNota(nota)
        }
    }

    fun eliminarNotas() {
        Coroutines.main{
            repository.eliminarNotas()
        }
    }

    fun mostrarNotas() {
        Coroutines.main{
            _notas.value = repository.mostrarNotas()
        }
    }

}