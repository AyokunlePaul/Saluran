package com.ayokunlepaul.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.local.models.CategoryLocalModel
import io.reactivex.Observable

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCategory(value: CategoryLocalModel): Long

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Observable<List<CategoryLocalModel>>
}