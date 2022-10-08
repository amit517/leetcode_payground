fun main() {
    val a = ListNode(24)
    val b = ListNode(2)
    val k = ListNode(40)
    val l = ListNode(50)
    val m = ListNode(60)

    //second list
    val e = ListNode(-1)
    val f = ListNode(3)
    val g = ListNode(4)
    val h = ListNode(5)

    a.next = b
    b.next = k
    k.next = l
    l.next = m

    e.next = f
    f.next = g
    g.next = h

//    val lists = arrayListOf<ListNode<Int>?>(a, null, e)


    printLinkedListValue(removeNthFromEnd(a, 2))
//    println(getValueArrayFromLinkedlist(a))
//    println(getTotalSumOfLinkedList(a))
//    println(getValueByIndex(a, 10))
//    println(hasCycle(a))
//    println(printLinkedListInReverseOrder(e))
}

fun removeNthFromEnd(
    head: ListNode?,
    n: Int,
): ListNode? {
    var current = head
    var length = 0

    while (current != null) {
        length++
        current = current.next
    }

    // 1 2 3 4
    if (length == n){
        return head?.next
    }

    // find node to remove | index = length - n - 1
    var nodeBeforeRemoveIndex = length - n - 1
    current = head
    for (i in 0 until nodeBeforeRemoveIndex) {
        current = current?.next
    }
    current?.next = current?.next?.next
    return head
}

fun mergeKLists(lists: Array<Node<Int>?>): Node<Int>? {

    var sortedNode: Node<Int>? = null

    for (i in 0 until lists.size) {
        sortedNode = mergeTwoLists(sortedNode, lists[i])
    }
    return sortedNode
}

fun mergeTwoLists(listOne: Node<Int>?, listTwo: Node<Int>?): Node<Int>? {
    if (listOne == null && listTwo == null) return null
    if (listOne == null) return listTwo
    if (listTwo == null) return listOne
    // storing the value of next elements
    // Just keeping this for future understanding
    // we can change the variable with equivalent assignment

    return if (listOne.value < listTwo.value) {
        listOne.next = mergeTwoLists(listOne.next, listTwo)
        listOne
    } else {
        listTwo.next = mergeTwoLists(listTwo.next, listOne)
        listTwo
    }
}

fun printLinkedListInReverseOrder(head: Node<Int>?) {
    if (head == null) return
    printLinkedListInReverseOrder(head.next)
    println(head.value)
}


fun hasCycle(head: Node<Int>?): Boolean {
    var currentNode = head
    val mutableMap = mutableListOf<Node<Int>>()

    while (currentNode != null) {
        if (mutableMap.contains(currentNode)) {
            return true
        } else {
            mutableMap.add(currentNode)
        }

        currentNode = currentNode.next
    }
    return false
}

fun zipperListProblem(
    listOne: Node<Int>?,
    listTwo: Node<Int>?
): Node<Int>? {
    if (listOne == null && listTwo == null) return null
    if (listOne == null) return listTwo
    if (listTwo == null) return listOne

    var next_1 = listOne.next
    var next_2 = listTwo.next
    listOne.next = listTwo
    listTwo.next = zipperListProblem(next_1, next_2)
    return listOne
}

fun reverseLinkedList(head: Node<Int>?, previousNode: Node<Int>? = null): Node<Int>? {
    if (head == null) return previousNode
    var temp = head.next
    head.next = previousNode
    return reverseLinkedList(temp, head)
}

fun getValueByIndex(head: Node<Int>?, target: Int): Int? {
    if (head == null) return null
    if (target == 0) return head.value
    return getValueByIndex(head.next, (target - 1))
}

fun getTotalSumOfLinkedList(head: Node<Int>?): Int {
    if (head == null) return 0
    return head.value + getTotalSumOfLinkedList(head.next)
}

fun getValueArrayFromLinkedlist(head: Node<Int>?): MutableList<Int>? {
    // Non-recursive process

    /*var mutableList = mutableListOf<Int>()

    var currentNode: Node<Int>? = head

    while (currentNode != null) {
        mutableList.add(currentNode.value)
        currentNode = currentNode.next
    }*/

    // Recursive Process
    var mutableList = mutableListOf<Int>()
    fillValues(head, mutableList)
    return mutableList
}

fun fillValues(head: Node<Int>?, mutableList: MutableList<Int>): MutableList<Int>? {
    if (head == null) return null
    mutableList.add(head.value)
    fillValues(head.next, mutableList)
    return mutableList
}


fun printLinkedListValue(head: ListNode?) {
    // Non-recursive process
    /*var currentNode: Node<Int>? = head

    while (currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }*/

    // Recursive Process
    if (head == null) return
    println(head.`val`)
    printLinkedListValue(head.next)
}
