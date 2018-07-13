package com.kotlin.docs

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

/**
 * Created by tao.liu on 2018/7/13.
 * 嵌套类
 */
fun main(args: Array<String>) {
    val demo = Outer1.Nested().foo() // == 2

    val demo2 = Outer2().Inner().foo() // == 1
}

class Outer1 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

//类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}
// 匿名内部类
// window.addMouseListener(object: MouseAdapter() {
//    override fun mouseClicked(e: MouseEvent) {
//        // ……
//    }
//
//    override fun mouseEntered(e: MouseEvent) {
//        // ……
//    }
// })