import kotlin.math.max

fun main() {
    val solution = Solution()
    println(solution.climbStairs(5))
}

class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        var current = 0
        var pointer1 = 2
        var pointer2 = 1
        for (i in 3..n) {
            current = pointer1 + pointer2
            pointer2 = pointer1
            pointer1 = current
        }
        return current
    }

    fun solution(S: String): Int {
        var totalInputs = S.split("\n")
        var numberArr: ArrayList<String> = ArrayList()
        var timeArray: ArrayList<String> = ArrayList()
        var map: HashMap<String, Int> = HashMap()
        for (i in totalInputs) {
            var numberAndTime = i.split(",")
            var number = numberAndTime[1]
            var time = numberAndTime[0]
            numberArr.add(number)
            timeArray.add(time)
        }
        var maxTime = 0
        var maxTimeNumber = "0"
        var totalPrice = 0
        for (i in 0..numberArr.size - 1) {
            var currentCallTime = timeArray[i]
            var times = currentCallTime.split(":")
            var hour = times[0].toInt()
            var minute = times[1].toInt()
            var second = times[2].toInt()
            var totalSecond = hour * 3600 + minute * 60 + second
            if (totalSecond >= 300) {
                val totalMinute = totalSecond / 60
                var second = totalSecond % 60
                totalPrice += totalMinute * 150
                if (second > 0) totalPrice += 150
            } else {
                totalPrice += totalSecond * 3
            }
            var numberToStore = numberArr[i].replace("-", "")

            var alreadyCallTimeLogged = map.getOrDefault(numberToStore, 0)
            map.put(numberToStore, alreadyCallTimeLogged + totalSecond)
            if (alreadyCallTimeLogged + totalSecond > maxTime) {
                maxTime = alreadyCallTimeLogged + totalSecond
                maxTimeNumber = numberToStore
            } else if (alreadyCallTimeLogged + totalSecond == maxTime) {
                if (numberToStore.toInt() < maxTimeNumber.toInt()) {
                    maxTime = alreadyCallTimeLogged + totalSecond
                    maxTimeNumber = numberToStore
                }
            }
        }
        for (i in 0..numberArr.size - 1) {
            var numberToStore = numberArr[i].replace("-", "")
            if (numberToStore == maxTimeNumber) {
                var currentCallTime = timeArray[i]
                var times = currentCallTime.split(":")
                var hour = times[0].toInt()
                var minute = times[1].toInt()
                var second = times[2].toInt()
                var totalSecond = hour * 3600 + minute * 60 + second
                if (totalSecond >= 300) {
                    val totalMinute = totalSecond / 60
                    var second = totalSecond % 60
                    totalPrice -= totalMinute * 150
                    if (second > 0) totalPrice -= 150
                } else {
                    totalPrice -= totalSecond * 3
                }
            }
        }
        return totalPrice
    }

}