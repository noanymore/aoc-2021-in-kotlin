fun main() {
    val sum : MutableList<Int> = mutableListOf()
    fun part1(input: List<String>): Int {
        var singSum : Int = 0
        for(a in input.indices){
            singSum = if (input[a]=="") singSum else singSum+input[a].toInt()
            if (a>input.size-2||input[a+1]==""){
                sum.add(singSum)
                singSum = 0
            }
        }
        return sum.max();
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput))
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

