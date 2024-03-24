fun main() {
    val topicArray = TopicArray()
    println(topicArray.LC_136_singleNumber(intArrayOf(2, 2, 1)))
    println(topicArray.LC_136_singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(topicArray.LC_136_singleNumber(intArrayOf(1)))
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

    fun LC_189_rotate(nums: IntArray, k: Int) {
        var rotationCount = k

        while (rotationCount >= 1) {
            var lastIndexedValue = nums[nums.size - 1]
            for (index in nums.indices) {
                val temp = nums[index]
                nums[index] = lastIndexedValue
                lastIndexedValue = temp
            }
            rotationCount--
        }
    }

    fun LC_136_singleNumber(nums: IntArray): Int {
        val hashMap = HashMap<Int, Int>()

        nums.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        var numberToReturn = 0
        for ((key, value) in hashMap) {
            if (value == 1) {
                numberToReturn = key
                break
            }
        }

        return numberToReturn
    }
}