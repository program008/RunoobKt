package com.kotlincn.example

import kotlin.math.absoluteValue
import kotlin.test.todo

/**
 *
 * Created by tao.liu on 2018/1/18.
 * 函数
 */

fun main(args: Array<String>) {
        //test2()
//        test3()
        test4()

}

fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
        todo { }
}

//覆盖方法总是使用与基类型方法相同的默认参数值。
// 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认
open class A2 {
        open fun foo(i: Int = 10) {

        }
}

class B2 : A2() {
        override fun foo(i: Int) {

        }  // 不能有默认值
}

/**
 * 如果一个默认参数在一个无默认值的参数之前，
 * 那么该默认值只能通过使用命名参数调用该函数来使用：
 */
fun foo(bar: Int = 0, baz: Int) { /* …… */
}

private fun test() {
        foo(baz = 2)
}

fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /* …… */
}

private fun test2() {
        foo(1) { println("hello") } // 使用默认值 baz = 1
        foo { println("hello") }    // 使用两个默认值 bar = 0 与 baz = 1
}

fun foo(vararg strings: String) { /* …… */
}

private fun test3() {
        foo(strings = *arrayOf("a", "b", "c"))
}

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
        //……
}

/**
 * 如果一个函数不返回任何有用的值，它的返回类型是 Unit。
 * Unit 是一种只有一个值——Unit 的类型。这个值不需要显式返回
 * Unit 返回类型声明也是可选的
 */
fun printHello(name: String?): Unit {
        if (name != null)
                println("Hello ${name}")
        else
                println("Hi there!")
        // `return Unit` 或者 `return` 是可选的
}

/**
 * 函数可以有泛型参数，通过在函数名前使用尖括号指定：
 */
/*
fun <T> singletonList(item: T): List<T> {
        // ……
}*/

/**
 * 尾递归函数
 * Kotlin 支持一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
 * 当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本：
 */
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

/**
 * 这段代码计算余弦的不动点（fixpoint of cosine），这是一个数学常数。
 * 它只是重复地从 1.0 开始调用 Math.cos，直到结果不再改变，产生0.7390851332151607的结果。
 * 最终代码相当于这种更传统风格的代码：
 */
private fun findFixPoint(): Double {
        var x = 1.0
        while (true) {
                val y = Math.cos(x)
                if (x == y) return x
                x = y
        }
}
private fun test4(){
        var findFixPoint = findFixPoint(2.0)
        println(findFixPoint)

        var findFixPoint1 = findFixPoint()
        println(findFixPoint1)

}
/*
要符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作。
在递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中。目前尾部递归只在 JVM 后端中支持。
 */