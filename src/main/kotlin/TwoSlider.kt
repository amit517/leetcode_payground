fun main() {
    val twoSlider = TwoSlider()

    twoSlider.LC_167_twoSum(intArrayOf(2, 7, 11, 15), 9).forEach {
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
}