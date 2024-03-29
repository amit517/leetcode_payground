import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

fun main() {
    val topicString = TopicString()
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    val isValid = topicString.LC_36_isValidSudoku(board)
    if (isValid) {
        println("The Sudoku board is valid.")
    } else {
        println("The Sudoku board is invalid.")
    }
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

    fun LC_36_isValidSudoku(board: Array<CharArray>): Boolean {

        val seen = HashSet<String>()

        for (i in board.indices) {
            for (j in board.indices) {
                val number = board[i][j]

                if (number != '.') {
                    if (!seen.add("$number in row $i") ||
                        !seen.add("$number in column $j") ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false
                }
            }
        }

        return true
    }

}