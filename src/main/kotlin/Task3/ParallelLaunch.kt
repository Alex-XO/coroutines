package Task3

import kotlinx.coroutines.*

/*
 Running three asynchronous tasks in parallel.
 The first task prints numbers from 1 to 10 with an interval of 1 second,
 the second prints letters from 'a' to 'j' with an interval of 500 milliseconds,
 the third emulates a long operation,
 after which a completion message is displayed.
 */

fun main() = runBlocking {
    val job1 = launch(Dispatchers.Default) {
        numberTask()
    }
    val job2 = launch(Dispatchers.IO) {
        alphabetTask()
    }
    val job3 = launch(Dispatchers.Default) {
        longRunningTask()
    }

    job1.join()
    job2.join()
    job3.join()

    println("All coroutines have finished executing")
}

suspend fun numberTask() {
    var count = 1
    while (count <= 10) {
        println("$count *${Thread.currentThread().name}")
        delay(1000)
        count++
    }
}

suspend fun alphabetTask() {
    for (element in 'a'..'j') {
        println("$element *${Thread.currentThread().name}")
        delay(500)
    }
}

suspend fun longRunningTask() {
    var count = 1
    while (count <= 10) {
        println("executing longRunningTask on...: ${Thread.currentThread().name}")
        delay(1000)
        count++
    }
}