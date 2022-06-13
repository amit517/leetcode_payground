fun main() {
    val arr: IntArray = intArrayOf(1,2,3,4)
    val solution = Solution()
    println(solution.containsDuplicate(arr))
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        var finalResult = false
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    finalResult = true
                    break
                }
            }
            if (finalResult) {
                break
            }
        }
        return finalResult
    }
}