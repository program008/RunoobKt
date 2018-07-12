package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/12.
 * 数据类
 */
fun main(args: Array<String>) {
destruction()
}

data class User(val name: String = "", val age: Int = 0)

data class Person1(val name: String) {
    var age: Int = 0
}

fun copy(){
    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
}

//数据类和解构声明

private fun destruction(){
    val jane = User("Jane", 35)
    val (name, age) = jane
    println("$name, $age years of age") // 输出 "Jane, 35 years of age"

    val pair = Pair(1,3)
    val (component1,component2) = pair
    println("$component1, $component2")

    val triple = Triple(1,3,2)
    val (t1,t2,t3) = triple
    println("$t1, $t2, $t3")
}