package Task4

import kotlinx.coroutines.*
import java.util.*

/*
Coroutine is waiting for a change in the status variable,
which is initially false and should become true after the user presses a key
 */

var status = false

fun main() = runBlocking {
    launch {
        while (readln().lowercase(Locale.getDefault()) != "start") {
            // Looping until correct input is given
        }
        status = true
    }

    launch {
        while (!status) {
            delay(1000)
        }
        println("Input has been made.")
    }

    println("Enter \"Start\"")
}