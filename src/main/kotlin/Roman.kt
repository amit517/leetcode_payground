fun main() {
    val roman = Roman()
    println(roman.leetCode_12_intToRoman(3))
}

class Roman {


    fun leetcode_13_romanToInt(s: String): Int {
        val romanToIntMap = HashMap<Char, Int>()
        romanToIntMap['I'] = 1
        romanToIntMap['V'] = 5
        romanToIntMap['X'] = 10
        romanToIntMap['L'] = 50
        romanToIntMap['C'] = 100
        romanToIntMap['D'] = 500
        romanToIntMap['M'] = 1000

        var sum = romanToIntMap.getOrDefault(s[s.lastIndex], 0)

        for (index in s.lastIndex - 1 downTo 0) {
            var currentIndexValue = romanToIntMap.getOrDefault(s[index], 0)
            var prevIndexValue = romanToIntMap.getOrDefault(s[index + 1], 0)

            if (currentIndexValue < prevIndexValue) {
                sum -= currentIndexValue
            } else {
                sum += currentIndexValue
            }
        }
        return sum
    }

    fun leetCode_12_intToRoman(num: Int): String {
        var givenNum = num
        val intCode = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val code = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        val string = StringBuilder()

        for (i in intCode.indices) {
            while (givenNum >= intCode[i]) {
                string.append(code[i])
                givenNum -= intCode[i]
            }
        }

        return string.toString()
    }
}