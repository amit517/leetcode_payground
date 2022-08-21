fun main() {
    val lionAnimal : Animle = Lion() // Child can be cast to its parent. Will get the behaviour of the child. If we call any method we will get the child methods
    lionAnimal.sleep()
    lionAnimal.eat()
    (lionAnimal as Lion).roarr() // We are explecetingly saying the compiler that this is an instance of lion
    lionAnimal.roarr()

    lionAnimal.controlTemp() // Calling it's parent methdo

    val mammalAnimal : Animle = Mammal() // Automatic upper cast possible
//    val mammalLion : Lion = Mammal() //Parent can't be cast to its child

//    (mammalAnimal as Lion).roar() // will lead to run time exception. as we are telling the compiler that it is a Lion object. But actually it's a mammal object which is a child of mammal. child cant be cast to it's parent.
}

class Solution {



    /*
        fun lengthOfLongestSubstring(input: String): Int {
           val set = HashSet<Char>()

           var longestOverAll = ""
           var longestTillNow = ""

           for (element in input) {

               if (set.isNotEmpty() && set.last() == element) {
                   longestTillNow = ""
                   set.clear()
               }
               longestTillNow += element
               set.add(element)
               if (longestTillNow.length > longestOverAll.length) {
                   longestOverAll = longestTillNow
               }
           }

           return longestOverAll.length
        }*/


    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var max = 0
        val occ = mutableMapOf<Char, Int>()

        for ((i, c) in s.withIndex()) {

            if (occ.containsKey(c)) {
                val seekPoint = occ[c]!! + 1
                start = Math.max(seekPoint, start)
            }

            val length = i - start + 1
            max = Math.max(length, max)
            occ[c] = i
        }
        return max
    }

    fun reverseBits(n: Int): Int {
        val binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0')
        val reverse = binary.reversed()
        val v2 = reverse.toLong(2)
        return v2.toInt()
    }

    fun missingNumber(nums: IntArray): Int {

        val heightNumber = nums.size
        var givenNumberSum = 0
        nums.forEach {
            givenNumberSum += it
        }
        return addNumbers(heightNumber) - givenNumberSum
    }

    private fun addNumbers(num: Int): Int {
        return if (num != 0)
            num + addNumbers(num - 1)
        else
            num
    }

    fun hammingWeight(n: Int): Int {
        val binary = Integer.toBinaryString(n)
        var numberOfOne = 0
        binary?.let {
            for (element in it) {
                if (element == '1') {
                    numberOfOne += 1
                }
            }
        }
        return numberOfOne
    }

    fun countBits(n: Int): IntArray {
        val mutableArray = mutableListOf<Int>()
        for (number in 0..n) {
            val binary = Integer.toBinaryString(number)
            var numberOfOne = 0
            for (element in binary) {
                if (element == '1') {
                    numberOfOne += 1
                }
            }
            mutableArray.add(numberOfOne)
        }
        return mutableArray.toTypedArray().toIntArray()
    }
}