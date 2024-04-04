fun main() {
    val twoSlider = TwoSlider()

    twoSlider.LC_15_threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).forEach {
        println(it)
    }
}

class TwoSlider {
    fun LC_125_isPalindrome(s: String): Boolean {
        val alphaNumericString = removeNonAlphanumericRegex(s).lowercase()

        var pointer_A = 0
        var pointer_B = alphaNumericString.length - 1

        while (pointer_A < pointer_B) {
            if (alphaNumericString[pointer_A] != alphaNumericString[pointer_B]) {
                return false
            }
            pointer_A++
            pointer_B--
        }

        return true
    }

    fun removeNonAlphanumericRegex(text: String): String {
        return text.replace(Regex("[^a-zA-Z0-9]"), "")
    }

    fun LC_167_twoSum(numbers: IntArray, target: Int): IntArray {
        var pointer_A = 0
        var pointer_B = numbers.size - 1
        while (pointer_A < pointer_B) {
            val sum = numbers[pointer_A] + numbers[pointer_B]

            if (sum > target) {
                pointer_B--
            } else if (sum < target) {
                pointer_A++
            } else {
                return intArrayOf(++pointer_A, ++pointer_B)
            }
        }

        return intArrayOf()
    }

    fun LC_15_threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = arrayListOf<List<Int>>()

        for (i in 0 until  nums.size - 2) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                var low = i + 1
                var high = nums.size - 1
                val sum = 0 - nums[i]

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(listOf(nums[i], nums[low], nums[high]))
                        while (low < high && nums[low] == nums[low + 1]) low++
                        while (low < high && nums[high] == nums[high - 1]) high--
                        low++
                        high--
                    } else if (nums[low] + nums[high] > sum) {
                        high--
                    } else {
                        low++
                    }
                }
            }
        }

        return result
    }
}