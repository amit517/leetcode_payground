import java.util.*
import kotlin.collections.HashMap
import kotlin.math.max

fun main() {
    val solution = Roman()

    println(solution.leetcode_13_romanToInt("MCMXCIV"))
}

class Solution {

    /*fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val mutableList = mutableListOf<List<Int>>()

       candidates.forEachIndexed { index, value ->
           var combinationalResult = calculateCombinationSum(candidates,value)
           combinationalResult?.let {
               mutableList.add(it)
           }
       }

       return mutableList

   }*/


    /**
     * Problem statement:
     * https://imgur.com/a/ah0F9yN
     * GAS station problem
     *
     */
    fun ArrayChallenge(strArr: Array<String>): String {
        var gasSt = strArr[0]
        var arr = strArr.slice(1..strArr.size - 1)

        var ans = -1
        for (i in 0..arr.size - 1) {
            var isPossible = true
            var cur = i
            var gas = 0
            for (j in i..i + arr.size) {
                var k = j % arr.size
                var a = arr[k].split(":")
                var gasCur = a[0].toInt()
                var gasNeeded = a[1].toInt()
                var totalGas = gas + gasCur
                if (totalGas < gasNeeded) {
                    isPossible = false
                    break
                } else {
                    gas = totalGas - gasNeeded
                }
            }
            if (isPossible) {
                ans = cur
                break
            }
        }
        if (ans != -1) return (ans + 1).toString()
        else return "impossible"
    }

    fun calculateCombinationSum(candidates: IntArray, target: Int): MutableList<Int>? {
        if (target == 0) return mutableListOf()
        if (target < 0) return null

        candidates.forEachIndexed { index, value ->
            var remainder = target - value
            var remainderResult = calculateCombinationSum(candidates, remainder)
            if (remainderResult != null) {
                remainderResult.add(value)
                return remainderResult
            }
        }
        return null
    }

    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var pointer_a = 0
        var pointer_b = 1

        while (pointer_a < nums.size && pointer_b < nums.size && nums[pointer_a] < nums[pointer_b]) {
            pointer_a++
            pointer_b++
        }


        return if (pointer_a + 1 == nums.size) {
            nums[0]
        } else {
            nums[pointer_a + 1]
        }
    }

    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        var current = 0
        var pointer1 = 2
        var pointer2 = 1
        for (i in 3..n) {
            current = pointer1 + pointer2
            pointer2 = pointer1
            pointer1 = current
        }
        return current
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var pointer_a = 0
        var pointer_b = 0
        var temInput = strs.toMutableList()

        val resultList = mutableListOf<List<String>>()

        while (pointer_a < temInput.size) {
            val tempListInsideLoop = mutableListOf<String>()
            tempListInsideLoop.add(temInput[pointer_a])
            temInput.removeAt(pointer_a)

            while (pointer_b < temInput.size) {
                if (anagramChecker(tempListInsideLoop.last(), temInput[pointer_b])) {
                    tempListInsideLoop.add(temInput[pointer_b])
                    temInput.removeAt(pointer_b)
                    continue
                }
                pointer_b += 1
            }
            if (tempListInsideLoop.isNotEmpty()) {
                resultList.add(tempListInsideLoop)
            }

            pointer_b = 0
        }
        return resultList
    }

    fun anagramChecker(s: String, t: String): Boolean {
        var tem = t
        if (s == null || t == null) return false
        if (s.length != t.length) return false

        for (i in s.indices) {
            if (!tem.contains(s[i])) {
                return false
            }
            val char = s[i]
            tem = tem.replaceFirst(char.toString(), "", false)
        }
        return true
    }

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
                pointerA += 1
            } else {
                maxArea = max(maxArea, height[pointerB] * (pointerB - pointerA))
                pointerB -= 1
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

    fun runningSum(nums: IntArray): IntArray {
        val mutableArray = mutableListOf<Int>()

        mutableArray.add(nums[0])
        for (number in 1 until nums.size) {
            val sum = nums[number] + mutableArray.last()
            mutableArray.add(sum)
        }

        return mutableArray.toIntArray()
    }
}