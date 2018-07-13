package com.kotlin.docs

import com.kotlincn.example.DataProvider
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * Created by tao.liu on 2018/7/13.
 * 对象表达式和对象声明
 */
fun main(args: Array<String>) {

}

//对象表达式

// 如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。
// 多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
open class Aa(x: Int) {
    public open val y: Int = x
}

interface Bb {
//……
}

val ab: Aa = object : Aa(1), Bb {
    override val y = 15
}

//任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
private fun fo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

/**
 * 匿名对象可以用作只在本地和私有作用域中声明的类型。
 * 如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
 * 那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，
 * 就会是 Any。在匿名对象中添加的成员将无法访问。
 */
class Cc {
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

// 就像 Java 匿名内部类一样，对象表达式中的代码可以访问来自包含它的作用域的变量。
// （与 Java 不同的是，这不仅限于 final 变量。）
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
    // ……
}


object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ……
    }

    //val allDataProviders: Collection<DataProvider>
        //get() = 1// ……
}


object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {
        // ……
    }

    override fun mouseEntered(e: MouseEvent) {
        // ……
    }
}

//注意：对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。

class MyClass1 {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

//该伴生对象的成员可通过只使用类名作为限定符来调用：
val instance = MyClass1.create()

class MyClass3 {
    companion object {
    }
}

val x = MyClass.Companion

// 请注意，即使伴生对象的成员看起来像其他语言的静态成员，
// 在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口：

interface Factory<T> {
    fun create(): T
}


class MyClass4 {
    companion object : Factory<MyClass4> {
        override fun create(): MyClass4 = MyClass4()
    }
}