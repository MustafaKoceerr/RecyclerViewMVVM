package com.example.recyclerviewmvvm

import com.example.recyclerviewmvvm.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {
    fun <T : Any> ioThenMain(call: suspend (() -> T?), callback: (T?) -> Unit): Job {

        return CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt call()
            }.await()
            // In Kotlin, await is a suspending function used to wait for the result of a Deferred without blocking the thread.
            // await() sayesinde bu işlem bitmeden aldınaki işler çalışmaz.
            callback(data)
        }

    }
}