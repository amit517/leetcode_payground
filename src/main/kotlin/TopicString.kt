import java.util.*
import kotlin.collections.LinkedHashMap

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


    fun leetcode_20_ValidParentheses(s: String): Boolean {
        if (s.length % 2 != 0) return false
        val stack = Stack<Char>()

        for (char in s) {
            when (char) {
                '(', '{', '[' -> {
                    stack.push(char)
                }

                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') stack.pop()
                    else return false
                }

                '}' -> {
                    if (stack.isNotEmpty() && stack.peek() == '{') stack.pop()
                    else return false
                }

                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') stack.pop()
                    else return false
                }
            }
        }

        return stack.isEmpty()
    }


    /**
     * Problem:
     * Having the function SearchingChallenge(str) take str parameter being passed and return 1 #ofBrackets if the brackets are correctly matched and each one is accounted for. Oterwise return 0. For example : if str is "(hello [world])(!)", then the output should be 1 3 because all the brackets are matched and there are 3 pairs of brackets, but if str is "((hello [world])" the the output should be 0 because the brackets do not correctly match up. Only "(", ")", "[", and "]" will be used as brackets. If str contains no brackets return 1.
        val result1 = SearchingChallenge("(hello [world])(!)")  // Output: 1 3
        val result2 = SearchingChallenge("((hello [world])")     // Output: 0
        val result3 = SearchingChallenge("no brackets here")    // Output: 1 0
     */

    fun SearchingChallenge(str: String): String {
        val stack = Stack<Char>()
        var numBrackets = 0

        for (char in str) {
            when (char) {
                '(', '[' -> {
                    stack.push(char)
                    numBrackets++
                }

                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return "0"
                    }
                }

                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return "0"
                    }
                }
            }
        }

        return if (stack.isEmpty()) "1 $numBrackets" else "0"
    }

}