fun main() {

    fun part1(input: String): Int {
        var map = hashMapOf<Char,Int>()
        var start = 0
        var end = start+1
        var nextStart = 0
        while (end-start<14){
            map.put(input[start],start)
            if(map.contains(input[end])){
                val bound = map[input[end]]
                map.remove(input[end])
                map.put(input[end+1],end+1)
                nextStart = if( map.isEmpty() ) start+1 else map.values.filter { it > bound!! }.min()
                start = nextStart
                end = nextStart
                map.clear()
            }else{
                map[input[end]] = end
            }
            end++
        }
        return end
    }

    fun part2(input: List<String>): Int {
        return 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput.joinToString()))
    check(part1(testInput.joinToString()) == 19)

    val input = readInput("Day01")
    part1(input.joinToString()).println()
    part2(input).println()
}

