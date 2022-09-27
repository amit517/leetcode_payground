fun main() {
    val solution = Solution()
    println(solution.fib(6))
    println(solution.fib(4))
    println(solution.fib(40))
    println(solution.fib(15))
}

class Solution {
    private val memo = mutableMapOf<Int, Int>()

    fun fib(number: Int): Int {
        if (memo.containsKey(number)) return memo[number]!!
        if (number == 0) return 0
        if (number == 1) return 1

        val result = fib(number - 1) + fib(number - 2)
        memo[number] = result
        return result
    }
}