package com.kotlin.docs

import com.sun.corba.se.impl.orbutil.graph.Graph
import sun.security.provider.certpath.Vertex
import kotlin.test.todo

/**
 * Created by tao.liu on 2018/7/13.
 * 函数
 */

//函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量：
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
    TODO("")
}

// 覆盖方法总是使用与基类型方法相同的默认参数值。
// 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值：
open class A15 {
    open fun foo(i: Int = 10) {
        TODO("")
    }
}

class B15 : A15() {
    override fun foo(i: Int) {
        TODO("")
    }  // 不能有默认值
}

//如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用命名参数调用该函数来使用：
fun foo(bar: Int = 0, baz: Int) { /* …… */ }

fun main(args: Array<String>) {
    foo(baz = 3) // 使用默认值 bar = 0

    foo15(1) { println("hello") } // 使用默认值 baz = 1
    foo15 { println("hello") }    // 使用两个默认值 bar = 0 与 baz = 1
}
// 不过如果最后一个 lambda 表达式参数从括号外传给函数函数调用，那么允许默认参数不传值：
fun foo15(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /* …… */ }


//可以在调用函数时使用命名的函数参数。当一个函数有大量的参数或默认参数时这会非常方便
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
    //……
}

fun testReformat(){
    reformat(str = "hello")
    //reformat(str= "hello", true, true, false, '_')
}

fun foo(vararg strings: String) { /* …… */ }
//可以通过使用星号操作符将可变数量参数（vararg） 以命名形式传入：
fun testfoo(){
    foo(strings = *arrayOf("a", "b", "c"))
}

//函数的参数（通常是最后一个）可以用 vararg 修饰符标记：

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

class MyStringCollection {
    infix fun add(s: String) { /* …… */ }

    fun build() {
        this add "abc"   // 正确
        add("abc")       // 正确
        //add "abc"        // 错误：必须指定接收者
    }
}

//局部函数
//fun dfs(graph: Graph) {
//    fun dfs(current: Vertex, visited: Set<Vertex>) {
//        if (!visited.add(current)) return
//        for (v in current.neighbors)
//            dfs(v, visited)
//    }
//
//    dfs(graph.vertices[0], HashSet())
//}


//局部函数可以访问外部函数（即闭包）的局部变量，所以在上例中，visited 可以是局部变量：
//
//fun dfs(graph: Graph) {
//    val visited = HashSet<Vertex>()
//    fun dfs(current: Vertex) {
//        if (!visited.add(current)) return
//        for (v in current.neighbors)
//            dfs(v)
//    }
//
//    dfs(graph.vertices[0])
//}

//函数可以有泛型参数，通过在函数名前使用尖括号指定：

//fun <T> singletonList(item: T): List<T> {
//    // ……
//}

/*
尾递归函数
Kotlin 支持一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本：

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))
这段代码计算余弦的不动点（fixpoint of cosine），这是一个数学常数。 它只是重复地从 1.0 开始调用 Math.cos，
直到结果不再改变，产生0.7390851332151607的结果。最终代码相当于这种更传统风格的代码：

private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (x == y) return x
        x = y
    }
}
要符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作。在递归调用后有更多代码时，不能使用尾递归，
并且不能用在 try/catch/finally 块中。目前尾部递归只在 JVM 后端中支持
 */