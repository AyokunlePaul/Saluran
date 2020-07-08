package com.ayokunlepaul.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.local.models.NewEpisodesLocalModel
import io.reactivex.Observable

@Dao
interface NewEpisodesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewEpisode(value: NewEpisodesLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewEpisodes(value: List<NewEpisodesLocalModel>)

    @Query("SELECT * FROM new_episodes")
    fun getAllNewEpisodes(): Observable<List<NewEpisodesLocalModel>>
}