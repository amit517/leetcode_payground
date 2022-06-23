fun main() {
    val solution = Solution()
    val numSt = Integer.parseUnsignedInt("11111111111111111111111111111101", 2)
    println(numSt)
    println(solution.hammingWeight(numSt))
}

class Solution {
    fun hammingWeight(n: Int): Int {
        val binary = Integer.toBinaryString(n)
        var numberOfOne = 0
        binary?.let {
            for (element in it) {
                if (element == '1') {
                    numberOfOne += 1
                }
            }
        }
        return numberOfOne
    }
}