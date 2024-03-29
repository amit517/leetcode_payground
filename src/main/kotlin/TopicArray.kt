import kotlin.math.max

fun main() {
    val topicArray = TopicArray()
    println(topicArray.LC_128_longestConsecutive(intArrayOf(100,4,200,1,3,2)))
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


    fun LC_238_productExceptSelf(nums: IntArray): IntArray {
        val arrayLength = nums.size

        val outputArr = IntArray(size = arrayLength) { 0 }
        val leftProduct = Array(size = arrayLength) { 0 }
        val rightProduct = Array(size = arrayLength) { 0 }

        leftProduct[0] = 1
        rightProduct[arrayLength - 1] = 1

        for (i in 1 until arrayLength) {
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1]
        }

        for (i in arrayLength - 2 downTo 0) {
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1]
        }

        for (i in 0 until arrayLength) {
            outputArr[i] = leftProduct[i] * rightProduct[i]
        }

        return outputArr
    }

    fun LC_128_longestConsecutive(nums: IntArray): Int {
        val numSet = HashSet<Int>()
        for (number in nums) {
            numSet.add(number)
        }
        var maxSequenceLength = 0
        for (number in nums) {
            var currentNum = number
            var currentSequenceLength = 1

            if (numSet.contains(currentNum - 1).not()) {
                while (numSet.contains(currentNum + 1)) {
                    currentNum++
                    currentSequenceLength++
                }
                maxSequenceLength = max(maxSequenceLength, currentSequenceLength)
            }
        }

        return maxSequenceLength
    }
}