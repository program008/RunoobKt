package com.kotlincn.example

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 *
 * Created by tao.liu on 2018/1/18.
 * 对象表达式和对象声明
 */
fun main(args: Array<String>) {
        foo()
}

/**
 * 如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。
 * 多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
 */
open class A(x: Int) {
        public open val y: Int = x
}

interface B {
        //……
}

private fun test1() {
        val ab: A = object : A(1),B{
                override val y = 15
        }
}

/**
 * 任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
 */
private fun foo(){
        val bar = object {
                var a = 1
                var b = 2
        }

        println("${bar.a}, ${bar.b}")
}

/**
 * 请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
 * 那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any。在匿名对象中添加的成员将无法访问。
 */
class C {
        // 私有函数，所以其返回类型是匿名对象类型
        private fun foo() = object {
                val x: String = "x"
        }

        // 公有函数，所以其返回类型是 Any
        fun publicFoo() = object {
                val x: String = "x"
        }

        fun bar() {
                val x1 = foo().x        // 没问题
                //val x2 = publicFoo().x  // 错误：未能解析的引用“x”
        }
}

/**
 * 对象声明
 * ----------------单例模式-------------------------
 * 这称为对象声明。并且它总是在 object 关键字后跟一个名称。
 * 就像变量声明一样，对象声明不是一个表达式，不能用在赋值语句的右边。
 */
object DataProviderManager {
        fun registerDataProvider() {
                // ……
        }

        //val allDataProviders: Collection<DataProvider>

}

enum class DataProvider {

}

/**
 * 注意：对象声明不能在局部作用域（即直接嵌套在函数内部），
 * 但是它们可以嵌套到其他对象声明或非内部类中。
 */
object DefaultListener : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
                // ……
        }

        override fun mouseEntered(e: MouseEvent) {
                // ……
        }
}

private fun test2(){
        DataProviderManager.registerDataProvider()
}

/**
 * 伴生对象
 */
class MyClass {
        companion object Factory {
                fun create(): MyClass = MyClass()
        }
}

private fun test3(){
        //该伴生对象的成员可通过只使用类名作为限定符来调用：

        val instance = MyClass.create()
}
class MyClass2 {
        companion object {
        }
        val x = MyClass2.Companion
}

interface Factory<T> {
        fun create(): T
}

/**
 * 请注意，即使伴生对象的成员看起来像其他语言的静态成员，
 * 在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口：
 */
class MyClass3 {
        companion object : Factory<MyClass3> {
                override fun create(): MyClass3 = MyClass3()
        }
}

/**
对象表达式和对象声明之间的语义差异

对象表达式和对象声明之间有一个重要的语义差别：
对象表达式是在使用他们的地方立即执行（及初始化）的；
对象声明是在第一次被访问到时延迟初始化的；
伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。
 */
