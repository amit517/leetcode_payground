fun main() {
    val topicString = TopicString()
    println(topicString.LC_387_firstUniqChar("leetcode"))
    println(topicString.LC_387_firstUniqChar("loveleetcode"))
    println(topicString.LC_387_firstUniqChar("aabb"))
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

    fun LC_387_firstUniqChar(s: String): Int {
        val hashMap = LinkedHashMap<Char, Int>()

        for (char in s) {
            hashMap[char] = hashMap.getOrDefault(char, 0) + 1
        }

        var nonRepIndex = -1

        for ((key, value) in hashMap) {
            if (value == 1) {
                nonRepIndex = s.indexOf(key)
                break
            }
        }

        return nonRepIndex
    }
}