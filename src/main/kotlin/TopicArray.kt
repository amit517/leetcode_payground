fun main() {
    val topicArray = TopicArray()
    topicArray.LC_350_intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).forEach {
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

    fun LC_350_intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val mutableArray = mutableListOf<Int>()
        val smallerArray: IntArray
        val biggerArray: IntArray
        if (nums1.size < nums2.size) {
            smallerArray = nums1
            biggerArray = nums2
        } else {
            smallerArray = nums2
            biggerArray = nums1
        }

        biggerArray.forEach {
            for (index in smallerArray.indices) {
                if (it == smallerArray[index]) {
                    mutableArray.add(it)
                    smallerArray[index] = -1
                    break
                }
            }
        }

        return mutableArray.toIntArray()
    }
}