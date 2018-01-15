package com.uurobot.kotlin

/**
 *
 * Created by tao.liu on 2018/1/15.
 * kotlin 接口
 *
 */

fun main(args: Array<String>) {
        test1()
        println("--------------------------")
        test2()
}

/**
 * Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
 *
 *
 * -------------------------接口中的属性-----------------------------------
 * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
 */
interface MyInterface {
        var name: String //name 属性, 抽象的
        fun bar()
        fun foo() {//可选方法
                println("foo()")
        }
}

class Child : MyInterface {
        override var name: String = "runoob"

        override fun bar() {
                //方法体
                println("bar()")
        }

}

private fun test1() {
        var chlid = Child()
        chlid.foo()
        chlid.bar()
        println(chlid.name)
}

/**
 * ------------------------------------------函数重写--------------------------------------------------
 * 实现多个接口时，可能会遇到同一方法继承多个实现的问题。例如:
 * 实例中接口 A 和 B 都定义了方法 foo() 和 bar()， 两者都实现了 foo(), B 实现了 bar()。
 * 因为 C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。
 * 然而，如果我们从 A 和 B 派生 D，我们需要实现多个接口继承的所有方法，并指明 D 应该如何实现它们。
 * 这一规则 既适用于继承单个实现（bar()）的方法也适用于继承多个实现（foo()）的方法。
 */
interface A1 {
        fun foo() {
                println("A")
        }   // 已实现

        fun bar()                  // 未实现，没有方法体，是抽象的
}

interface B2 {
        fun foo() {
                println("B")
        }   // 已实现

        fun bar() {
                println("bar")
        } // 已实现
}

class C2 : A1 {
        override fun bar() {
                println("bar()----------c")
        }

}

class D2 : A1, B2 {
        override fun foo() {
                super<A1>.foo()
                super<B2>.foo()
        }

        override fun bar() {
                super<B2>.bar()
        }

}

private fun test2() {
        var d2 = D2()
        d2.foo()
        d2.bar()

        var c2 = C2()
        c2.foo()
        c2.bar()
}