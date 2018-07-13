package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/13.
 * description this is description
 */
fun main(args: Array<String>) {
    val baseImpl = BaseImpl(1)
    Derived(baseImpl).print()

    val b = BaseImpl14(10)
    Derived14(b).printMessage()
    Derived14(b).printMessageLine()

    val b2 = BaseImpl15(10)
    val derived = Derived15(b2)
    derived.print()
    println(derived.message)

    println(lazyValue)
    println(lazyValue)
}

//由委托实现
//委托模式已经证明是实现继承的一个很好的替代方式， 而 Kotlin 可以零样板代码地原生支持它。
//Derived 类可以通过将其所有公有成员都委托给指定对象来实现一个接口 Base：
interface Basez {
    fun print()
}

class BaseImpl(val x: Int) : Basez {
    override fun print() { print(x) }
}

class Derived(b: Basez) : Basez by b
// Derived 的超类型列表中的 by-子句表示 b 将会在 Derived 中内部存储，
// 并且编译器将生成转发给 b 的所有 Base 的方法。



// 覆盖由委托实现的接口成员
// 覆盖符合预期：编译器会使用 override 覆盖的实现而不是委托对象中的。
// 如果将 override fun print() { print("abc") } 添加到 Derived，
// 那么当调用 print 时程序会输出“abc”而不是“10”：
interface Base14 {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl14(val x: Int) : Base14 {
    override fun printMessage() { print(x) }
    override fun printMessageLine() { println(x) }
}

class Derived14(b: Base14) : Base14 by b {
    override fun printMessage() { print("abc") }
}

//但请注意，以这种方式重写的成员不会在委托对象的成员中调用 ，
//委托对象的成员只能访问其自身对接口成员实现：
interface Base15 {
    val message: String
    fun print()
}

class BaseImpl15(val x: Int) : Base15 {
    override val message = "BaseImpl: x = $x"
    override fun print() { println(message) }
}

class Derived15(b: Base15) : Base15 by b {
    // 在 b 的 `print` 实现中不会访问到这个属性
    override val message = "Message of Derived"
}


val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}