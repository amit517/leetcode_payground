package AccessModifiers

open class Person {
    private val relation  = "Not accessible from child or anywhere else"
    protected val protectedSalary = 500 // Can be accessible to it's child classes
    internal val officeEnvironment = "Only be accessible from with in the kotlin module"
    val workLocation = "Can be accessible from anywhere. By default kotlin fields are public and final"
}

class Amit() : Person() {

}


/* Protected can't be top level function. It can only be on the member function / methods */
//protected class AmitInternal() : Person() {
//
//}