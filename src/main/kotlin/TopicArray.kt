fun main() {
    val topicArray = TopicArray()
    val intArray = intArrayOf(1,2,3,4,5,6,7)
    topicArray.LC_189_rotate(intArray, 3)
    intArray.forEach {
        println(it)
    }
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
            var lastIndexedValue =  nums[nums.size - 1]
            for (index in nums.indices) {
                val temp = nums[index]
                nums[index] = lastIndexedValue
                lastIndexedValue = temp
            }
            rotationCount--
        }
    }
}