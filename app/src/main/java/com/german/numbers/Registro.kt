package com.german.numbers

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Registro(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    @ColumnInfo(name = "registro") val number: Int
)
