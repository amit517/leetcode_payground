import java.util.Arrays.toString
import kotlin.math.max

fun main() {
    val solution = Solution()
    println(solution.fib(6))
}

class Solution {

    fun fib(number: Int): Int {
        if (number == 0) return 0
        if (number == 1) return 1

        return fib(number-1)+fib(number-2)
    }
}