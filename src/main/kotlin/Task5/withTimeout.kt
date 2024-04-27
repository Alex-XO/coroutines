package Task5

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlin.random.Random

/*
A function that outputs Fibonacci numbers
for a limited time (5 seconds) using withTimeout.
The task involves random delays.
If the time is up, the program handles a TimeoutCancellationException
and tells the user that the time has expired.
 */

fun main() = runBlocking {
    try {
        withTimeout(5000L) {
            var a = 0
            var b = 1
            println(a)
            println(b)
            var sum: Int

            for (i in 2..1000) {
                sum = a + b
                a = b
                b = sum
                println(b)
                val delayTime = Random.nextLong(200L, 1000L)
                delay(delayTime)
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("Time's up.")
    }
}

