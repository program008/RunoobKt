package com.kotlin.docs

import kotlin.test.todo

/**
 * Created by tao.liu on 2018/7/12.
 * 类与继承
 */

fun main(args: Array<String>) {
    var demo = InitOrderDemo("ryan")
    println("${demo.firstProperty} ,${demo.secondProperty}")
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

open class Base {
    open fun v() {}
    fun nv() {}
}

class Driver() :Base(){
    override fun v() {
    }
}


open class Foo {
    open val x: Int get(){return x}
    open fun f(){}
}

class Bar1 : Foo() {
    override val x: Int = 1//
}

interface Fooo {
    val count: Int
}

class Barr1(override val count: Int) : Fooo

class Bar2 : Fooo {
    override var count: Int = 0
}
class Bar : Foo() {
    override fun f() { /* …… */ }
    override val x: Int get() = 0

    inner class Baz {
        fun g() {
            super@Bar.f() // 调用 Foo 实现的 f()
            println(super@Bar.x) // 使用 Foo 实现的 x 的 getter
        }
    }
}

open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // 接口成员默认就是“open”的
    fun b() { print("b") }
}

class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }
}
