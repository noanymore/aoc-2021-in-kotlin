fun main() {
//mjqjpqmgbljsphdztnvjfqwrcgsmlb
    fun part1(input: String): Int {
        var start = 0
        var end = 0
        var nextStart = 0
        var hasNext = false
        val cache = hashMapOf<Char,Int>()
        cache.put(input[start],start)
        while (end - start < 14){
            if (end == start) end++
            if (!cache.contains(input[end])){
                cache[input[end]] = end
                if(!hasNext) {
                    nextStart = end
                    hasNext = true
                }
            }else {
                val index = cache[input[end]]
                if(index == end-1){
                    nextStart = end+1
                }else{
                    nextStart = cache.values.filter { it > index!! }.min()
                }
                start = nextStart
                end = nextStart
                hasNext = false
                cache.clear()
                cache[input[start]] = start
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

