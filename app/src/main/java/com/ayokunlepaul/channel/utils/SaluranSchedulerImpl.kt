package com.ayokunlepaul.channel.utils

import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SaluranSchedulerImpl @Inject constructor() : SaluranScheduler {

    override val observationThread: Scheduler = AndroidSchedulers.mainThread()

    override val executionThread: Scheduler = Schedulers.io()
}