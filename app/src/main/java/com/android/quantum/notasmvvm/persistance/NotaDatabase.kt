package com.android.quantum.notasmvvm.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.quantum.notasmvvm.models.Nota

@Database(entities = [Nota::class], version = 1)
abstract class NotaDatabase: RoomDatabase() {

    abstract fun getNotaDao(): NotaDao

    companion object {

        @Volatile private var instance: NotaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NotaDatabase::class.java,
            "nota_db"
        ).fallbackToDestructiveMigration().build()

    }

}