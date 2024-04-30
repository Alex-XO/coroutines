package Task6

import kotlinx.coroutines.*
import java.util.*

/*
A coroutine that performs a task periodically (every 2 seconds).
The task should be executed indefinitely or until the
user decides to stop it (enter S).
delay to control the time between executions and isActive to check
whether the coroutine has been canceled.
 */

fun main() = runBlocking {
    val job = launch (Dispatchers.Default) {
        while (isActive) {
            println("Doing some work...")
            delay(2000)
        }
    }

    launch {
        while (isActive) {
            val input = withContext(Dispatchers.IO) {
                readlnOrNull()
            }

            if (input?.lowercase(Locale.getDefault()) == "s") {
                println("Stopping the job...")
                job.cancel()
            }
        }

    }
    job.join()
    println("Input has been made.")
}

