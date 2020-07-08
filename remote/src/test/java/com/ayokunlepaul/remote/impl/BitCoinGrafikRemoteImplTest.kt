package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.remote.utils.Creator
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BitCoinGrafikRemoteImplTest {

    @MockK
    lateinit var service: BitCoinGrafikChartService

    private val mapper = BitCoinChartValueRemoteModelMapper()
    private val impl by lazy { BitCoinGrafikRemoteImpl(service, mapper) }

    private val testChartValue = Creator.create()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `test that getCharts return data`() {
        val chartName = "market-price"
        val queryMap = hashMapOf("timespan" to "30days")
        every { service.getCharts(chartName, queryMap) } returns
                Single.just(BaseBitcoinGrafikRemoteModel(data = testChartValue, status = "ok", unit = "USD"))
        val emittedValue = mutableListOf<BitCoinChartValueEntity>()
        val testObserver = impl.getBitCoinValuesRemote(chartName, queryMap).doOnSuccess {
            emittedValue.addAll(it)
        }.test()
        assertEquals(mapper.mapToRepositoryList(testChartValue), emittedValue)
        testObserver.assertComplete()
    }
}