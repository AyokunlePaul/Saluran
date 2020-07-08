package com.ayokunlepaul.data.interactors.utils

internal object Creator {

    fun create(): List<BitCoinChartValue> {
        return listOf(
            BitCoinChartValue(xAxis = "1542585600", yAxis = "5303.9425"),
            BitCoinChartValue(xAxis = "1542672000", yAxis = "4671.97"),
            BitCoinChartValue(xAxis = "1542758400", yAxis = "4533.680833333334"),
            BitCoinChartValue(xAxis = "1542844800", yAxis = "4548.7975"),
            BitCoinChartValue(xAxis = "1542931200", yAxis = "4309.337500000001"),
            BitCoinChartValue(xAxis = "1543017600", yAxis = "4293.840833333333")
        )
    }
}