package com.kotlincn.example

import java.awt.SystemColor.window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 *
 * Created by tao.liu on 2018/1/18.
 *
 * 嵌套类和内部类
 */
fun main(args: Array<String>) {
        test1()
}
//嵌套类
class Outer{
        private val bar = 1

        class Nested{
                fun foo() = 2
        }
}

//内部类
class Outher2{
        private val bar = 1
        inner class Inner{
                fun foo() = bar
        }
}

private fun test1(){
        var foo = Outer.Nested().foo()
        println(foo)
        var foo1 = Outher2().Inner().foo()
        println(foo1)
}

/*
This 表达式

为了表示当前的 接收者 我们使用 this 表达式：

在类的成员中，this 指的是该类的当前对象。
在扩展函数或者带接收者的函数字面值中， this 表示在点左侧传递的 接收者 参数。
如果 this 没有限定符，它指的是最内层的包含它的作用域。要引用其他作用域中的 this，请使用 标签限定符：

限定的 this

要访问来自外部作用域的this（一个类 或者扩展函数， 或者带标签的带接收者的函数字面值）我们使用this@label，其中 @label 是一个代指 this 来源的标签：

class A { // 隐式标签 @A
    inner class B { // 隐式标签 @B
        fun Int.foo() { // 隐式标签 @foo
            val a = this@A // A 的 this
            val b = this@B // B 的 this

            val c = this // foo() 的接收者，一个 Int
            val c1 = this@foo // foo() 的接收者，一个 Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit 的接收者
            }


            val funLit2 = { s: String ->
                // foo() 的接收者，因为它包含的 lambda 表达式
                // 没有任何接收者
                val d1 = this
            }
        }
    }
}
 */
/**
 * 匿名内部类

使用对象表达式创建匿名内部类实例：

window.addMouseListener(object: MouseAdapter() {
override fun mouseClicked(e: MouseEvent) {
// ……
}

override fun mouseEntered(e: MouseEvent) {
// ……
}
})
如果对象是函数式 Java 接口（即具有单个抽象方法的 Java 接口）的实例， 你可以使用带接口类型前缀的lambda表达式创建它：

val listener = ActionListener { println("clicked") }
 */
private fun test2(){
      /*  window.addMouseListener(object: MouseAdapter() {
                override fun mouseClicked(e: MouseEvent) {
                        // ……
                }

                override fun mouseEntered(e: MouseEvent) {
                        // ……
                }
        }) */
}
