fun main() {
    val solution = Solution()
    val array = mutableListOf(9,6,4,2,3,5,7,0,1)
    println(solution.missingNumber(array.toIntArray()))
}

class Solution {

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