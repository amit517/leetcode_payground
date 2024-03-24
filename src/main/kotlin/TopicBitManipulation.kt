fun main() {
    val topicString = TopicBitManipulation()
    println(topicString.LC_7_reverse(1534236469))
}

class TopicBitManipulation {
    /**
     * https://www.youtube.com/watch?v=HAgLH58IgJQ
     */

    fun LC_7_reverse(x: Int): Int {
        var givenNumber = x
        var res = 0
        var pop = 0
        while (givenNumber != 0) {
            pop = givenNumber % 10
            givenNumber /= 10

            if (res > Int.MAX_VALUE || (res == Int.MAX_VALUE / 10 && pop >= Int.MAX_VALUE % 10) || res > Int.MAX_VALUE / 10) {
                return 0
            }

            if (res < Int.MIN_VALUE || (res == Int.MIN_VALUE / 10 && pop <= Int.MIN_VALUE % 10) || res < Int.MIN_VALUE / 10) {
                return 0
            }
            res = (res * 10) + pop
        }
        return res
    }
}