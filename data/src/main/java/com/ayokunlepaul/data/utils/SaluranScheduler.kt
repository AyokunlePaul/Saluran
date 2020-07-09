package com.ayokunlepaul.data.utils

import io.reactivex.Scheduler

interface SaluranScheduler {
    val observationThread: Scheduler
    val executionThread: Scheduler
}