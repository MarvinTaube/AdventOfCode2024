import java.io.File
import kotlin.math.absoluteValue

fun main(){
    val input = File("./inputs/day3.txt").readText()
    Day3.part1(input)
    Day3.part2(input)
}

object Day3 {
    fun part1(input: String){

        var sum = 0
        //regex match pattern
        val matches = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)").findAll(input)
        matches.forEach {
            val numbers = it.value.replace(Regex("mul\\(|\\)"), "").split(",")
            sum += numbers[0].toInt() * numbers[1].toInt()
        }
        println("Solution Part 1: $sum")
    }

    fun part2(input: String){
        //added or conditions for matching
        val matches = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)").findAll(input)

        var sum = 0
        var active = true
        matches.forEach {
            if (it.value == "do()") {
                active = true
            } else if (it.value == "don't()") {
                active = false
            } else if (active){
                val numbers = it.value.replace(Regex("mul\\(|\\)"), "").split(",")
                sum += numbers[0].toInt() * numbers[1].toInt()
            }
        }
        println("Solution Part 2: $sum")
    }
}

/*
Should be a good enough solution. It runs for parts 1 and 2 in linear time
 */