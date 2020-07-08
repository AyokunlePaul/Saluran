package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.remote.utils.Creator
import org.junit.Assert.assertEquals
import org.junit.Test

class BitCoinChartValueRemoteModelMapperTest {

    private val mapper = BitCoinChartValueRemoteModelMapper()

    @Test
    fun testBlockchainChartValueRemoteModelMapper() {
        val data = BaseBitcoinGrafikRemoteModel(data = Creator.create(), status = "ok", unit = "USD")
        val chartModel = data.data
        val mappedData = mapper.mapToRepositoryList(data.data)

        assertEquals(chartModel.size, mappedData.size)
    }
}