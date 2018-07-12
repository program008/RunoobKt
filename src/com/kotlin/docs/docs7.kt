package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/12.
 * 可见性修饰符
 */
fun main(args: Array<String>) {

}
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected
}
//Kotlin 中外部类不能访问内部类的 private 成员
class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见


    //局部变量、函数和类不能有可见性修饰符。
}

