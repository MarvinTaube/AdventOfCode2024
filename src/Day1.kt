import java.io.File
import kotlin.math.abs

/**
 * Prework:
 * Used Regex replace to remove the second array from the first and placed them in separate files.
 */

fun main() {

    val firstArray = File("./inputs/day1_first_array.txt").readLines()
    val secondArray = File("./inputs/day1_second_array.txt").readLines()

    //result part 1
    println("Solution Part 1: " + part1(firstArray, secondArray));

    //result part 2
    println("Solution Part 2: " + part2(firstArray, secondArray))
}

fun part1(firstArray: List<String>, secondArray: List<String>): Int {
    val firstArraySorted = firstArray.sorted()
    val secondArraySorted = secondArray.sorted()

    var distance = 0;

    for (i in firstArray.indices) {
        if (firstArraySorted[i] == secondArraySorted[i]) {
            continue
        }
        distance += abs(firstArraySorted[i].toInt() - secondArraySorted[i].toInt())
    }

    return distance;
}

fun part2(firstArray: List<String>, secondArray: List<String>): Int {
    val firstArraySorted = firstArray.sorted()
    val secondArraySorted = secondArray.sorted()

    var similarityScore = 0;

    for (i in firstArraySorted.indices) {
        var occurrences = 0
        val index = secondArraySorted.indexOf(firstArraySorted[i])
        if (index != -1) {
            while (firstArraySorted[i] == secondArraySorted[index + occurrences]){
                occurrences++
            }
        }
        similarityScore += firstArraySorted[i].toInt() * occurrences
    }

    return similarityScore
}