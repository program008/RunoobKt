package com.kotlin.docs

import java.lang.Integer.parseInt

/**
 * Created by tao.liu on 2018/7/9.
 * 控制流：if、when、for、while
 */
fun main(args: Array<String>) {
//    if1()
//    when1()
    for1()
}

private fun if1() {
    // 在 Kotlin 中，if是一个表达式，即它会返回一个值。
    // 因此就不需要三元运算符（条件 ? 然后 : 否则），因为普通的 if 就能胜任这个角色。
    // 传统用法
    val a = 1
    val b = 2
    var max = a
    if (a < b) max = b

    // With else
    val max1: Int
    if (a > b) {
        max1 = a
    } else {
        max1 = b
    }

    // 作为表达式
    val max2 = if (a > b) a else b

    //if的分支可以是代码块，最后的表达式作为该块的值：
    val max3 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}

private fun when1() {
    val x = 1
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }
    //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    //我们可以用任意表达式（而不只是常量）作为分支条件
    val s = "1"
    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }

    //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
    when (x) {
        in 1..10 -> print("x is in the range")
        //in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    // 检测一个值是（is）或者不是（!is）一个特定类型的值。
    // 注意： 由于智能转换，你可以访问该类型的方法和属性而无需任何额外的检测。
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    // when 也可以用来取代 if-else if链。 如果不提供参数，
    // 所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：

//    when {
//        x.isOdd() -> print("x is odd")
//        x.isEven() -> print("x is even")
//        else -> print("x is funny")
//    }
}

private fun for1(){
    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    val array = intArrayOf(1, 2, 3, 4, 5)
    for (i in array) {
        println(i)
    }

    for (i in array.indices) {
        println(array[i])
    }

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}

private fun while1(){
    //while 和 do..while 照常使用
    var x = 100
    while (x > 0) {
        x--
    }

    //do {
        //val y = retrieveData()
    //} while (y != null) // y 在此处可见
}







