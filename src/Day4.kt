import java.io.File

fun main(){
    val input = File("./inputs/day4.txt").readLines().map {
        it.toCharArray().toList()
    }
    Day4.part1(input)
    Day4.part2(input)
}

object Day4 {

    //idea is to run once though the whole text and at each X look for the numbers of XMAS that can be build with it.
    //add them together and you have the total count
    fun part1(input: List<List<Char>>){
        var counter = 0
        for(row in input.indices){
            for(column in input[row].indices){
                if (input[row][column] == 'X'){
                    counter += fulfillsXmasByX(input, row, column)
                }
            }
        }
        println(counter)
    }

    //finds for a given X at row, column the number of XMAS that can be built with it
    fun fulfillsXmasByX(input: List<List<Char>>, row: Int, column: Int): Int{
        var xmasCounter = 0

        //check horizontal
        //left & out of bounce
        if (column - 3 >= 0) {
            if (input[row][column-1] == 'M' &&
                input[row][column-2] == 'A' &&
                input[row][column-3] == 'S') {
                xmasCounter++
                println("left $row $column")
            }
        }
        //right & out of bounce
        if (column + 3 <= input[row].indices.last) {
            if (input[row][column+1] == 'M' &&
                input[row][column+2] == 'A' &&
                input[row][column+3] == 'S') {
                xmasCounter++
                println("right $row $column")
            }
        }

        //check vertical
        //up & out of bounce
        if (row - 3 >= 0) {
            if (input[row-1][column] == 'M' &&
                input[row-2][column] == 'A' &&
                input[row-3][column] == 'S'){
                xmasCounter++
                println("up $row $column")
            }
        }

        //down & out of bounce
        if (row + 3 <= input.indices.last) {
            if (input[row+1][column] == 'M' &&
                input[row+2][column] == 'A' &&
                input[row+3][column] == 'S'){
                xmasCounter++
                println("down $row $column")
            }
        }

        //check diagonal
        //top left & out of bounce
        if (row - 3 >= 0 && column - 3 >= 0) {
            if (input[row-1][column-1] == 'M' &&
                input[row-2][column-2] == 'A' &&
                input[row-3][column-3] == 'S') {
                xmasCounter++
                println("left up $row $column")
            }
        }

        //top right & out of bounce
        if (row - 3 >= 0 && column + 3 <= input[row].indices.last) {
            if (input[row-1][column+1] == 'M' &&
                input[row-2][column+2] == 'A' &&
                input[row-3][column+3] == 'S') {
                xmasCounter++
                println("right up $row $column")
            }
        }


        //bottom left & out of bounce
        if (row + 3 <= input.indices.last && column - 3 >= 0){
            if (input[row+1][column-1] == 'M' &&
                input[row+2][column-2] == 'A' &&
                input[row+3][column-3] == 'S') {
                xmasCounter++
                println("left down $row $column")
            }
        }

        //bottom right & out of bounce
        if (row + 3 <= input.indices.last && column + 3 <= input[row].indices.last){
            if (input[row+1][column+1] == 'M' &&
                input[row+2][column+2] == 'A' &&
                input[row+3][column+3] == 'S') {
                xmasCounter++
                println("right down $row $column")
            }
        }

        println(xmasCounter)
        return xmasCounter
    }

    //Same idea for the second part. Look for the center 'A' and validate if the conditions for an X-MAS are met
    fun part2(input: List<List<Char>>){
        var counter = 0
        var charCounter = 0
        for(row in input.indices){
            for(column in input[row].indices){
                if (input[row][column] == 'A' && fulfillsXmasByA(input, row, column)){
                    counter++
                }
            }
        }
        println("Part 2: $counter");
    }

    fun fulfillsXmasByA(input: List<List<Char>>, row: Int, column: Int): Boolean{

        //out of bounce check
        if (row + 1 <= input.indices.last &&
            row - 1 >= 0 &&
            column + 1 <= input[row].indices.last &&
            column - 1 >= 0){
            if ((input[row+1][column+1] == 'M' && input[row-1][column-1] == 'S' ||
                input[row+1][column+1] == 'S' && input[row-1][column-1] == 'M') &&
                (input[row+1][column-1] == 'M' && input[row-1][column+1] == 'S' ||
                input[row+1][column-1] == 'S' && input[row-1][column+1] == 'M')) {
                return true
            }
        }

        return false
    }
}
