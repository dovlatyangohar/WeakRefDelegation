import java.lang.ref.WeakReference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class WeakRefExample<T>(private var value: WeakReference<T?>) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return value.get()
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun <T> weak(value: T) = WeakRefExample(WeakReference(value))
fun main() {
    val name by weak("Jack")
    val age by weak(45)
    println(age)
    println(name)
}

//right version
//import java.lang.ref.WeakReference
//import kotlin.properties.ReadWriteProperty
//import kotlin.reflect.KProperty
//
//class WeakRefExample<R, T>(private var value: WeakReference<T?>) : ReadWriteProperty<R, T?> {
//
//    override fun getValue(thisRef: R, property: KProperty<*>): T? {
//        return value.get()
//    }
//
//    override fun setValue(thisRef: R, property: KProperty<*>, value: T?) {
//        println("$value has been assigned to '${property.name}' in $thisRef.")
//    }
//
//
//}
//
//fun <R, T> weak(value: T) = WeakRefExample<R, T>(WeakReference(value))
//fun main() {
//
//    val name by weak("Jack")
//    val age by weak(45)
//    println(age)
//    println(name)
//}
