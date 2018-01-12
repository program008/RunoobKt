package com.uurobot.kotlin

/**
 * kotlin 条件控制
 */
fun main(args: Array<String>) {
        fun1()
        fun4()
}

fun fun1() {
        // 传统用法
        val a = 2
        var max: Int = 0
        var b = 3
        if (a < b) max = b
        println(max)

// 使用 else
//        var max: Int
//        if (a > b) {
//                max = a
//        } else {
//                max = b
//        }

// 作为表达式
        //val max = if (a > b) a else b
}

fun fun2() {
        val a = 2
        var max: Int = 0
        var b = 3
        if (a > b) {
                max = a
        }
        else {
                max = b
        }
}

fun fun3() {
        val a = 3
        val b = 2
        val max = if (a > b) a else b
}

fun fun4() {
        var x = 0
        when (x) {
                0, 1 -> println("x == 0 or x == 1")
                else -> println("otherwise")
        }

        when (x) {
                1 -> println("x == 1")
                2 -> println("x == 2")
                else -> { // 注意这个块
                        println("x 不是 1 ，也不是 2")
                }
        }

        when (x) {
                in 0..10 -> println("x 在该区间范围内")
                else -> println("x 不在该区间范围内")
        }


        val items = setOf("apple", "banana", "kiwi")
        when {
                "orange" in items -> println("juicy")
                "apple" in items -> println("apple is fine too")
        }
}