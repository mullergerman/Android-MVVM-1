package com.german.numbers

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegistroDao {
    @Query("SELECT * FROM registro")
    fun getAll(): LiveData<List<Registro>>

    @Insert
    suspend fun insertAll(vararg registros: Registro)

}
