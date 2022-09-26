fun main() {
    val a = Node(value = 2)
    val b = Node(value = 8)
    val c = Node(value = 3)
    val d = Node(value = 7)

    a.next = b
    b.next = c
    c.next = d

//    printLinkedListValue(a)
//    println(getValueArrayFromLinkedlist(a))
//    println(getTotalSumOfLinkedList(a))
//    println(getValueByIndex(a, 10))
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


fun printLinkedListValue(head: Node<Int>?) {
    // Non-recursive process
    /*var currentNode: Node<Int>? = head

    while (currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }*/

    // Recursive Process
    if (head == null) return
    println(head.value)
    printLinkedListValue(head.next)
}
