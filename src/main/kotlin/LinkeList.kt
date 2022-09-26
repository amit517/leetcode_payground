fun main() {
    val a = Node(value = 1)
    val b = Node(value = 2)
    val c = Node(value = 3)
    val d = Node(value = 4)

    a.next = b
    b.next = c
    c.next = d

    printLinkedListValue(a)
}

fun printLinkedListValue(head: Node<Int>?) {
    // Non-recursive process
    /*var currentNode: Node<Int>? = a

    while (currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }*/

    // Recursive Process
    if (head == null) return
    println(head.value)
    printLinkedListValue(head.next)
}
