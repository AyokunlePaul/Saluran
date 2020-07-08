package com.ayokunlepaul.domain.utils

import io.reactivex.Scheduler

interface SaluranScheduler {
    val observationThread: Scheduler
    val executionThread: Scheduler
}