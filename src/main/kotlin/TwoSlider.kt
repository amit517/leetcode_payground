fun main() {
    val twoSlider = TwoSlider()

    println(twoSlider.LC_125_isPalindrome("A man, a plan, a canal: Panama"))
    println(twoSlider.LC_125_isPalindrome("race a car"))
    println(twoSlider.LC_125_isPalindrome(" "))
}

class TwoSlider {
    fun LC_125_isPalindrome(s: String): Boolean {
        val alphaNumericString = removeNonAlphanumericRegex(s).lowercase()

        var pointer_A = 0
        var pointer_B = alphaNumericString.length - 1

        while (pointer_A < pointer_B) {
            if (alphaNumericString[pointer_A] != alphaNumericString[pointer_B]){
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
}