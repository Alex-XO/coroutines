package Task4

import kotlinx.coroutines.*
import java.util.*

/*
Coroutine is waiting for a change in the status variable,
which is initially false and should become true after the user presses a key
 */

var statuses = false

fun main() = runBlocking {
    println("Enter \"Start\"")

    val jobInput = launch {
        while (readln().lowercase(Locale.getDefault()) != "start") {
            // Looping until correct input is given
        }
        statuses = true
    }

    val jobWait = launch {
        while (!statuses) {
            println("Waiting for the user to type 'Start'...")
            delay(1000)
        }
    }

    jobInput.join()
    jobWait.cancel()
    println("Input has been made.")
}