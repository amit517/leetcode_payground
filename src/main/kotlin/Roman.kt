fun main() {
    val roman = Roman()

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

}