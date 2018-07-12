package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/12.
 * 接口
 */
fun main(args: Array<String>) {

}

interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
    }
}

class Child : MyInterface {
    override fun bar() {
        // 方法体
    }
}

/**
 * 接口中的属性
 * 你可以在接口中定义属性。在接口中声明的属性要么是抽象的，要么提供访问器的实现。
 * 在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。
 */
interface MyInterface2 {
    val prop: Int // 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child2 : MyInterface2 {
    override val prop: Int = 29
}

/**
 * 接口继承
 * 一个接口可以从其他接口派生，从而既提供基类型成员的实现也声明新的函数与属性。
 * 很自然地，实现这样接口的类只需定义所缺少的实现：
 */
interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

class Position {}
data class Employee(
        // 不必实现“name”
        override val firstName: String,
        override val lastName: String,
        val position: Position
) : Person

/**
 * 解决覆盖冲突
 */
interface A1 {
    fun foo() { print("A") }
    fun bar()
}

interface B1 {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C1 : A1 {
    override fun bar() { print("bar") }
}

class D1 : A1, B1 {
    override fun foo() {
        super<A1>.foo()
        super<B1>.foo()
    }

    override fun bar() {
        super<B1>.bar()
    }
}