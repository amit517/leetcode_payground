import kotlin.math.max

var mutableList = mutableListOf<Int>()
fun main() {
    var a = TreeNode(2)
    var b = TreeNode(1)
    var c = TreeNode(3)
    var d = TreeNode(6)
    var e = TreeNode(20)

    a.left = b
    a.right = c
    b.left = null
    b.right = null
    c.left = null
    c.right = null


    /* b.left = null
     b.right = c*/

    println(inorderTraversal(invertTree(a)))
}
fun levelOrder(root: TreeNode?): List<List<Int>> {
    // todo https://leetcode.com/problems/binary-tree-level-order-traversal/
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    var left = invertTree(root.right)
    var right = invertTree(root.left)

    root.left = left
    root.right = right

    return root
}

fun isValidBST(root: TreeNode): Boolean {
    val low = -Double.MAX_VALUE
    val high = Double.MAX_VALUE

    return if (root.left == null && root.right == null) true else valid(root, low, high)
}

fun valid(root: TreeNode?, low: Double, high: Double): Boolean {
    if (root == null) return true

    //Check duplicates
    if (root.left != null && root.left!!.`val` == root.`val`) return false
    if (root.right != null && root.right!!.`val` == root.`val`) return false

    //Check bounds of valid values
    return if (root.`val` >= high || root.`val` <= low) false else valid(
        root.left, low, root.`val`.toDouble()
    ) && valid(root.right, root.`val`.toDouble(), high)
}

fun inorderTraversal(root: TreeNode?, list: List<Int>? = null): List<Int> {
    if (root == null) return list ?: emptyList()

    var mutableList = mutableListOf<Int>()
    var left = inorderTraversal(root.left, list)
    var right = inorderTraversal(root.right, list)

    mutableList.addAll(left)
    mutableList.add(root.`val`)
    mutableList.addAll(right)

    return mutableList
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (q == null || p == null) return false
    if (p.`val` != q.`val`) return false

    return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return (1 + max(maxDepth(root.left), maxDepth(root.right)))
}