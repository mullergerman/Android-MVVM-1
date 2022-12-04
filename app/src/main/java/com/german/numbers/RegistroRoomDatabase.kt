package com.german.numbers

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Registro::class], version = 1)
abstract class RegistroRoomDatabase : RoomDatabase(){
    abstract fun registroDao(): RegistroDao
}