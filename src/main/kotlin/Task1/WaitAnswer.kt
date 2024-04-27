package Task1

import kotlinx.coroutines.*

/*
    Until the answer to the question is received, the countdown is underway
 */

var answer: String? = null

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        longRunningTask()
    }

    println("1 + 1 = *${Thread.currentThread().name}")

    var i = 10
    while (answer == null && i != 1) {
        println(i)
        println(Thread.currentThread().name)
        delay(1000)
        i--
    }

    if (answer != null) {
        println("Answer = $answer *${Thread.currentThread().name}")
        job.cancel()
    } else {
        println("You lose. *${Thread.currentThread().name}")
    }

    println("My program run ends... *${Thread.currentThread().name}")
}

suspend fun longRunningTask() {
    println("Task thread: ${Thread.currentThread().name}")
    withContext(Dispatchers.IO) {
        answer = readlnOrNull()
    }
}
