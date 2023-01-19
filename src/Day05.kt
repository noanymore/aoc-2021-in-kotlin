import java.util.Stack
import kotlin.math.min

fun main() {
    fun part1(input: List<String>): String {
        var depth = 0
        while (input[depth].contains("[")){
            depth++
        }
        val stacks : List<MutableList<String>> = input[depth-1].split(4).map { if (it.isBlank()) mutableListOf() else mutableListOf(it.filter { it!='['&&it!=']'&&it!=' ' }) }
        for(i in depth-2 downTo 0){
            val s = input[i]
            for(index in 0 until s.length/4+1){
                stacks[index].add(
                    s.substring(index*4, min((index*4+4) , s.length)).filter { it!='['&&it!=']'&&it!=' ' }
                )
                if (stacks[index].last().isNullOrEmpty()) stacks[index].removeLast()
            }
        }
        for(i in depth+2 until input.size){
            val stringArray = input[i].split(" ").filter { it != "move" && it != "from" && it!="to" &&it!="" }
            val num = stringArray[0].toInt()
            val from = stringArray[1].toInt()-1
            val to = stringArray[2].toInt()-1
            for(times in 0 until num){
                stacks[to].add(stacks[from].last())
                stacks[from].removeLast()
            }
        }
        var result = ""
        stacks.forEach { result += if (it.isEmpty()) " " else it.last() }
        return result
    }

    fun part2(input: List<String>): String {
        var depth = 0
        while (input[depth].contains("[")){
            depth++
        }
        val stacks : MutableList<MutableList<String>> = input[depth-1].split(4).map { if (it.isBlank()) mutableListOf() else mutableListOf(it.filter { it!='['&&it!=']'&&it!=' ' }) }
            .toMutableList()
        for(i in depth-2 downTo 0){
            val s = input[i]
            for(index in 0 until s.length/4+1){
                stacks[index].add(
                    s.substring(index*4, min((index*4+4) , s.length)).filter { it!='['&&it!=']'&&it!=' ' }
                )
                if (stacks[index].last().isNullOrEmpty()) stacks[index].removeLast()
            }
        }
        for(i in depth+2 until input.size){
            val stringArray = input[i].split(" ").filter { it != "move" && it != "from" && it!="to" &&it!="" }
            val num = stringArray[0].toInt()
            val from = stringArray[1].toInt()-1
            val to = stringArray[2].toInt()-1
            stacks[to].addAll(stacks[from].subList(stacks[from].size-num,stacks[from].size))
            stacks[from] = stacks[from].subList(0,stacks[from].size-num)

        }
        var result = ""
        stacks.forEach { result += if (it.isEmpty()) " " else it.last() }
        return result
    }

    val testInput = readInput("Day01_test")
    println(part2(testInput))
    check(part2(testInput) == "MCD")

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}


fun String.split(stepNum:Int) : List<String> {
    val length = this.length;
    val list = mutableListOf<String>()
    for(index in 0  .. Math.ceil((length/stepNum).toDouble()).toInt()){
        list.add(this.substring(index*stepNum,min(index*stepNum+stepNum,length)))
    }
    return list
}
