fun main() {
    fun part1(input: List<String>): Int {
        var sum : Int = 0
        for(s in input){
            var index = 0
            val hashSet : HashSet<Char> = HashSet()
            while(index < s.length/2 ){
                hashSet.add(s.elementAt(index))
                index++
            }
            while(index < s.length){
                val c = s.elementAt(index)
                if (hashSet.contains(c)){
                    sum += if(c in 'a'..'z') c-'a'+ 1 else c-'A'+27
                    break
                }else{
                    index++
                    continue
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum : Int = 0
        for(index in input.indices step 3){
            val hashset : HashSet<Char> = HashSet()
            for(c1 in input[index+1]){
                if (input[index].contains(c1))
                    hashset.add(c1)
            }
            for (c2 in input[index+2]){
                if (hashset.contains(c2)){
                    sum += if(c2 in 'a'..'z') c2-'a'+ 1 else c2-'A'+27
                    break
                }
            }
        }
        return sum
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 157)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
