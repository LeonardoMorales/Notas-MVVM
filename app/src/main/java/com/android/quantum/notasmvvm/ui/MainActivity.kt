package com.android.quantum.notasmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.android.quantum.notasmvvm.R
import com.android.quantum.notasmvvm.utils.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        subscribeObservers()

    }

    private fun subscribeObservers() {
        viewModel.mostrarNotas()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.nav_eliminar_notas -> {
                this.showToast("Notas eliminadas")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
