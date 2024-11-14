package com.example.gregorycedraz_rm94404.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gregorycedraz_rm94404.model.DicaModel

@Database(entities = [DicaModel::class], version = 1)
abstract class DicaDatabase : RoomDatabase() {

    abstract fun dicaDao(): DicaDao
}