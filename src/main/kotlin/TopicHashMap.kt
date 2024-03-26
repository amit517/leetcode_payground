fun main() {
    val hashMap = TopicHashMap()
}

class TopicHashMap {

    fun LC_1_twoSum(nums: IntArray, target: Int): IntArray {
        val prevHashMap = HashMap<Int, Int>()

        for ((index, value) in nums.withIndex()) {
            val diff = target - value
            if (prevHashMap.containsKey(diff)) return intArrayOf(prevHashMap[diff]!!, index)
            else prevHashMap[value] = index
        }

        return intArrayOf()
    }

    fun LC_347_topKFrequent(nums: IntArray, k: Int): IntArray {
        var count = k

        val hashMap = HashMap<Int, Int>()

        nums.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        val mutableIntArray = mutableListOf<Int>()
        var currentTop: Pair<Int, Int> = Pair(Int.MIN_VALUE, Int.MIN_VALUE)
        while (count >= 1) {
            for ((key, value) in hashMap) {
                if (value > currentTop.first) {
                    currentTop = Pair(value, key)
                }
            }

            mutableIntArray.add(currentTop.second)
            hashMap[currentTop.second] = Int.MIN_VALUE
            currentTop = Pair(Int.MIN_VALUE, Int.MIN_VALUE)
            count--
        }
        return mutableIntArray.toIntArray()
    }
}