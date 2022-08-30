import kotlin.math.max

fun main() {
    val solution = Solution()
    val array = arrayOf(1,8,6,2,5,4,8,3,7)
    println(solution.maxArea(array.toIntArray()))
}

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var pointerA = 0
        var pointerB = height.size - 1

        while (pointerA < pointerB) {
            if (height[pointerA] < height[pointerB]) {
                maxArea = max(maxArea, height[pointerA] * (pointerB - pointerA))
                pointerA+=1
            } else {
                maxArea = max(maxArea, height[pointerB] * (pointerB - pointerA))
                pointerB-=1
            }
        }
        return maxArea
    }

    fun subIntSummation(number: Int): Int {
        var string = number.toString()

        for (i in string.indices) {
            for (j in (i + 1) until string.length) {
                val sb = StringBuilder(string).also {
                    val previousChar = string[i]
                    println("previous char for index $i is $previousChar")

                    it.setCharAt(i, string[j])
                    it.setCharAt(j, previousChar)
                }
                val result = sb.toString()
                println(result)
            }
        }


        return 0
    }

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