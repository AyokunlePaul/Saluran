package com.ayokunlepaul.remote

import com.ayokunlepaul.remote.services.SaluranService
import com.ayokunlepaul.remote.utils.JsonLoader
import com.ayokunlepaul.remote.utils.okhttp
import com.ayokunlepaul.remote.utils.retrofit
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class SaluranServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var service: SaluranService

    @Before
    fun setup() {
        mockWebServer.start()
        val okHttpClient = okhttp {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }
        service = retrofit {
            baseUrl(mockWebServer.url("/"))
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            client(okHttpClient)
        }.create(SaluranService::class.java)
    }

    @After
    fun cleanUp() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test that new episodes return accurately`() {
        val newEpisodesJson = JsonLoader.getJson("new_episodes.json")
        val response =
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(newEpisodesJson)
        mockWebServer.enqueue(response)

        service.getNewEpisodes().test()
            .assertComplete()
            .assertValueCount(1)
            .assertValue {
                it.data.media.size == 2
            }.assertNoErrors()
    }

    @Test
    fun `test that channels are returned accurately`() {
        val newEpisodesJson = JsonLoader.getJson("channels.json")
        val response =
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(newEpisodesJson)
        mockWebServer.enqueue(response)

        service.getAllChannels().test()
            .assertComplete()
            .assertValueCount(1)
            .assertValue {
                it.data.channels?.size == 2
            }.assertValue {
                !it.data.channels?.get(1)?.slug.isNullOrBlank()
            }.assertNoErrors()
    }
}