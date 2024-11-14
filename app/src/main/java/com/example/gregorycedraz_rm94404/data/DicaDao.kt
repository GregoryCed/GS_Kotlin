package com.example.gregorycedraz_rm94404.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gregorycedraz_rm94404.model.DicaModel

@Dao
interface DicaDao {

    @Query("SELECT * FROM DicaModel")
    fun getAll(): LiveData<List<DicaModel>>

    @Insert
    fun insert(item: DicaModel)

    @Delete
    fun delete(item: DicaModel)
}