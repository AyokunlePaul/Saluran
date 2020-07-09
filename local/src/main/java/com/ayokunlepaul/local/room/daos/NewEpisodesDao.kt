package com.ayokunlepaul.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.local.models.NewEpisodeLocalModel
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface NewEpisodesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewEpisode(value: NewEpisodeLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewEpisodes(value: List<NewEpisodeLocalModel>): Single<Int>

    @Query("SELECT * FROM new_episodes")
    fun getAllNewEpisodes(): Observable<List<NewEpisodeLocalModel>>
}