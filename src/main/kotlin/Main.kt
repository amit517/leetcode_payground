fun main() {
    val arr: IntArray = intArrayOf(-1,1,0,-3,3)
    val solution = Solution()
    println()

    solution.productExceptSelf(arr).forEach {
        println(it)
    }
}

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val mutablelist = mutableListOf<Int>()
        val multiplyValue = nums.reduce { acc, i ->
            if (i != 0) {
                acc * i
            } else {
                acc
            }
        }
        for (i in nums.indices) {
            if (nums[i] != 0) {
                mutablelist.add(multiplyValue / nums[i])
            } else {
                mutablelist.add(multiplyValue)
            }
        }
        return mutablelist.toIntArray()
    }
}