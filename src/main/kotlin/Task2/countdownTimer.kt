package Task2

import kotlinx.coroutines.*

/*
    The program outputs the number of seconds in reverse order,
    starting from the number that the user entered
 */

fun main() = runBlocking {
    print("Enter the number of seconds: *${Thread.currentThread().name}")
    val input = readlnOrNull()
    var countSec: Int
    if (input != null) {
        countSec = input.toInt()
        val job = launch(Dispatchers.Default) {
            while (countSec >= 1) {
                println("$countSec *${Thread.currentThread().name}")
                delay(1000)
                countSec--
            }
            println("The end of the countdown. *${Thread.currentThread().name}")
        }
        job.join()
    }

    println("My program run ends... *${Thread.currentThread().name}")
}
