fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for(s in input){
            val stringArray = s.split(",")
            val a = stringArray[0].split("-")
            val a1 = a[0].toInt()
            val a2 = a[1].toInt()
            val b = stringArray[1].split("-")
            val b1 = b[0].toInt()
            val b2 = b[1].toInt()
            if((a1<=b1&&a2>=b2) ||(a1>=b1&&a2<=b2)) {
//                println(key + "," + map2[key])
                sum += 1
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for(s in input){
            val stringArray = s.split(",")
            val a = stringArray[0].split("-")
            val a1 = a[0].toInt()
            val a2 = a[1].toInt()
            val b = stringArray[1].split("-")
            val b1 = b[0].toInt()
            val b2 = b[1].toInt()
            if((a2<b1) ||(b2<a1)) {
//                println(key + "," + map2[key])
                sum += 1
            }
        }
        return input.size - sum
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 2)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
