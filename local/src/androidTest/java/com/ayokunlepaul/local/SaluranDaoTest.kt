package com.ayokunlepaul.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ayokunlepaul.local.room.SaluranDatabase
import com.ayokunlepaul.local.room.daos.CategoriesDao
import com.ayokunlepaul.local.room.daos.ChannelsDao
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.utils.SaluranTestUtils
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SaluranDaoTest {

    private lateinit var database: SaluranDatabase
    private lateinit var categoriesDao: CategoriesDao
    private lateinit var channelsDao: ChannelsDao
    private lateinit var episodesDao: NewEpisodesDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, SaluranDatabase::class.java).build()
        categoriesDao = database.getCategoriesDao()
        channelsDao = database.getChannelsDao()
        episodesDao = database.getNewEpisodesDao()
    }

    @Test
    fun saveIntoCategoriesTable() {
        val data = SaluranTestUtils.createCategories()
        categoriesDao.insertChannels(data)
        categoriesDao.getAllCategories().test().assertComplete().assertValueCount(1)
            .assertValue {
                it.size == data.size
            }.assertNoErrors()
    }

    @Test
    fun saveIntoChannelsTable() {
        val data = SaluranTestUtils.createChannels()
        channelsDao.insertChannels(data)
        channelsDao.getAllChannels().test().assertComplete().assertValueCount(1)
            .assertValue {
                it.size == data.size
            }.assertNoErrors()
    }

    @Test
    fun saveIntoNewEpisodesTable() {
        val data = SaluranTestUtils.createNewEpisodes()
        episodesDao.insertNewEpisodes(data)
        episodesDao.getAllNewEpisodes()¬.test().assertComplete().assertValueCount(1)
            .assertValue {
                it.size == data.size
            }.assertNoErrors()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }
}