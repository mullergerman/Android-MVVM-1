package com.german.numbers

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room

class RegistroRepository(application: Application) {
    private var registroDao: RegistroDao
    private var liveData: LiveData<List<Registro>>

    init{
        val db = Room.databaseBuilder(
            application.applicationContext,
            RegistroRoomDatabase::class.java, "database-name"
        ).build()

        registroDao = db.registroDao()
        liveData = registroDao.getAll()
    }

    fun getAllRegistros(): LiveData<List<Registro>> {
        return liveData
    }

    suspend fun insertRegistro(registro:Registro){
        registroDao.insertAll(registro)
    }

}