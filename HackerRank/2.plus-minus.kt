import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    val size = arr.size
    var a = 0
    var b = 0
    var c = 0
    for (i in 0..size - 1) {
        if (arr[i] > 0) {
            a++
        }
        if (arr[i] < 0) {
            b++
        }
    }
    c =  size - a - b
    
    val resultA = String.format("%.6f", a.toDouble() / size)
    val resultB = String.format("%.6f", b.toDouble() / size)
    val resultC = String.format("%.6f", c.toDouble() / size)
    
    println(resultA)
    println(resultB)
    println(resultC)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
