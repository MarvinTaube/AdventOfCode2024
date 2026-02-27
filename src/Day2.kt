import java.io.File
import kotlin.math.absoluteValue

fun main(){
    val input = File("./inputs/day2.txt").readLines()
    Day2.part1(input)
}

object Day2 {
    fun isValidRow(row: MutableList<Int>): Boolean{
        if (row.size <= 1){
            return true
        }

        val is_increasing = row[0] < row[1]

        for (i in 0 until row.size-1){
            if ((row[i] - row[i+1]).absoluteValue !in 1..3){
                return false
            }

            if (is_increasing && row[i] > row[i+1]){
                return false
            } else if(!is_increasing && row[i] < row[i+1]){
                return false
            }
        }

        return true
    }

    fun part1(input: List<String>){
        var validInputs = 0;

        val invalidInputs = mutableListOf<MutableList<Int>>()

        input.forEach {
            val values = it.split(" ").map { it.toInt() }.toMutableList()
            if (isValidRow(values)){
                validInputs++
            } else {
                invalidInputs.add(values)
            }
        }

        println("Part1: $validInputs")
        println("Part2: ${validInputs + part2(invalidInputs)}")
    }

    //part 2
    fun part2(input: MutableList<MutableList<Int>>) : Int{
        var validRedundancyInputs = 0
        for (row in input){
            var isValidRedundancy = false
            //bruteforce approach
            for (value in row.indices){
                val tmpRow = row.toMutableList()
                tmpRow.removeAt(value)
                isValidRedundancy = isValidRedundancy || isValidRow(tmpRow)
            }
            if (isValidRedundancy){
                validRedundancyInputs++
            }
        }
        return validRedundancyInputs
    }

    /*
    Alternative approach idea:
    while checking if a row is valid, if you encounter an error
    remove both elements you compare currently after each other. if the
    list is valid with one of them removed, return true, false otherwise
     */
}

