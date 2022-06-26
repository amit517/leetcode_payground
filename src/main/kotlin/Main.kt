import kotlin.math.pow

fun main() {
    val solution = Solution()
    val numSt = Integer.parseUnsignedInt("11111111111111111111111111111101", 2)
    println(solution.reverseBits(numSt))
}

class Solution {

    fun reverseBits(n: Int): Int {
        val binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0')
        val reverse = binary.reversed()
        val v2 = reverse.toLong(2)
        return v2.toInt()
    }

    fun missingNumber(nums: IntArray): Int {

        val heightNumber = nums.size
        var givenNumberSum = 0
        nums.forEach {
            givenNumberSum += it
        }
        return addNumbers(heightNumber) - givenNumberSum
    }

    private fun addNumbers(num: Int): Int {
        return if (num != 0)
            num + addNumbers(num - 1)
        else
            num
    }

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

    fun countBits(n: Int): IntArray {
        val mutableArray = mutableListOf<Int>()
        for (number in 0..n) {
            val binary = Integer.toBinaryString(number)
            var numberOfOne = 0
            for (element in binary) {
                if (element == '1') {
                    numberOfOne += 1
                }
            }
            mutableArray.add(numberOfOne)
        }
        return mutableArray.toTypedArray().toIntArray()
    }
}