fun main() {
    val topicArray = TopicArray()
    println(topicArray.LC_26_removeDuplicates(intArrayOf(1, 1, 2)))
}

class TopicArray {

    fun LC_26_removeDuplicates(nums: IntArray): Int {
        var uniqueNumber = 0

        val hashMap = LinkedHashMap<Int, Int>()

        nums.forEach {
            if (hashMap.containsKey(it).not()) {
                uniqueNumber++
                hashMap[it] = it
            }
        }

        var index = 0

        for ((key, value) in hashMap) {
            nums[index] = value
            index++
        }

        return uniqueNumber
    }
}