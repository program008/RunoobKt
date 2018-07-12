package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/12.
 * 扩展
 */
fun main(args: Array<String>) {
    //这个例子会输出 "c"，因为调用的扩展函数只取决于参数 c 的声明类型，该类型是 C 类
    //printFoo(D())

    //C4().foo()
    C4().foo(1)
}

open class C3

class D : C3()

fun C3.foo() = "c"

fun D.foo() = "d"

fun printFoo(c: C3) {
    println(c.foo())
}

class C4 {
    fun foo() { println("member") }
}

fun C4.foo() { println("extension") }

//当然，扩展函数重载同样名字但不同签名成员函数也完全可以：
fun C4.foo(i: Int) { println("extension") }

fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

//扩展属性
val <T> List<T>.lastIndex: Int
    get() = size - 1

/*
注意：由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。这就是为什么扩展属性不能有初始化器。
他们的行为只能由显式提供的 getters/setters 定义。

例如:

val Foo.bar = 1 // 错误：扩展属性不能有初始化器
 */


/**
 * 伴生对象的扩展
 * 如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性：
 */
class MyClass {
    companion object { }  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    // ……
}
