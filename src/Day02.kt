fun main() {

    //'x'-'a'=23
    fun part1(input: List<String>): Int {
        var sum = 0
        for(s in input){
            val charArray = s.toCharArray().filter { it.isLetter() }
            val a = charArray[1]-charArray[0]
            var num1 = 0;
            var num2 = 0
            num1 = when(a){
                25 -> 0
                24 -> 6
                23 -> 3
                22 -> 0
                21 -> 6
                else -> {0}
            }
            num2 = when(charArray[1]){
                'X' -> 1
                'Y' -> 2
                'Z' -> 3
                else -> {0}
            }
            sum += num1 + num2
        }
        return sum
    }
    //x y z shu ping ying
    fun part2(input: List<String>): Int {
        var sum = 0;
        for(s in input){
            val charArray = s.toCharArray().filter { it.isLetter() }
            val num1 = when(charArray[1]){
                'X' -> 0
                'Y' -> 3
                'Z' -> 6
                else -> {0}
            }
            val num0 = when(charArray[1]){
                'Y' -> charArray[0] - 'A' + 1
                'X' -> if(charArray[0] == 'A') 3 else charArray[0]-'A'
                'Z' -> if(charArray[0] == 'C') 1 else charArray[0]-'A'+2
                else -> {0}
            }
            sum+= num1 + num0
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 12)

    val input = readInput("Day01")
//    part1(input).println()
    part2(input).println()
}

