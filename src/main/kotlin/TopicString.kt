fun main() {
    val topicString = TopicString()

}

class TopicString {

    fun LC_433_reverseString(s: CharArray) {
        var pointer_A = 0
        var pointer_B = s.size - 1

        while (pointer_A <= pointer_B) {
            val char = s[pointer_B]
            s[pointer_B] = s[pointer_A]
            s[pointer_A] = char
            pointer_A++
            pointer_B--
        }
    }
}