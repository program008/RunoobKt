package com.kotlin.docs

import kotlin.reflect.jvm.internal.impl.protobuf.Internal

/**
 * Created by tao.liu on 2018/7/7.
 * kotlin基本类型
 */
fun main(args: Array<String>) {
    //numberConst()
    //showMode()
    //println("'0'= ${'0'.toInt()}, ${decimalDigitValue('9')}")
    arrayType()
}

/**
 * 1,数字常量的表示
 */
private fun numberConst() {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println("$oneMillion, $creditCardNumber, $socialSecurityNumber, $hexBytes, $bytes")
}

/**
 * 显示方式
 * 在 Java 平台数字是物理存储为 JVM 的原生类型，
 * 除非我们需要一个可空的引用（如 Int?）或泛型。 后者情况下会把数字装箱
 * 这里应该跟 Java 中是一样的，在范围是 [-128, 127] 之间并不会创建新的对象，
 * 比较输出的都是 true，从 128 开始，比较的结果才为 false。
 */
private fun showMode() {
    val a: Int = 128
    println(a === a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // ！！！输出“false”！！！

    println(boxedA == anotherBoxedA) // 输出“true”
}

/**
 * 2,显式转换
 * 由于不同的表示方式，较小类型并不是较大类型的子类型。 如果它们是的话，就会出现下述问题
 */
private fun showCovert() {
    // 假想的代码，实际上并不能编译：

    /* val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
     val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
     print(b == a) // 惊！这将输出“false”鉴于 Long 的 equals() 会检测另一个是否也为 Long
     */
    //因此较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
    /*val b1: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b1 // 错误*/
    val b: Byte = 1
    val i: Int = b.toInt() // OK: 显式拓宽

    //每个数字类型支持如下的转换
    /*
        toByte(): Byte
        toShort(): Short
        toInt(): Int
        toLong(): Long
        toFloat(): Float
        toDouble(): Double
        toChar(): Char
    */
    //缺乏隐式类型转换并不显著，因为类型会从上下文推断出来，而算术运算会有重载做适当转换，例如
    val l = 1L + 3 // Long + Int => Long
}

/**
 * 运算
 * 这是完整的位运算列表（只用于 Int 和 Long）：
 * shl(bits) – 有符号左移 (Java 的 <<)
 * shr(bits) – 有符号右移 (Java 的 >>)
 * ushr(bits) – 无符号右移 (Java 的 >>>)
 * and(bits) – 位与
 * or(bits) – 位或
 * xor(bits) – 位异或
 * inv() – 位非
 */
private fun operation() {
    //对于位运算，没有特殊字符来表示，而只可用中缀方式调用命名函数
    val x = (1 shl 2) and 0x000FF000
}

/**
 * 浮点数比较
 */
private fun floatCompare() {
/*
相等性检测：a == b 与 a != b
比较操作符：a < b、 a > b、 a <= b、 a >= b
区间实例以及区间检测：a..b、 x in a..b、 x !in a..b
当其中的操作数 a 与 b 都是静态已知的 Float 或 Double 或者它们对应的可空类型（声明为该类型，或者推断为该类型，
或者智能类型转换的结果是该类型），两数字所形成的操作或者区间遵循 IEEE 754 浮点运算标准。

然而，为了支持泛型场景并提供全序支持，当这些操作符并非静态类型为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，
这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：

认为 NaN 与其自身相等
认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
认为 -0.0 小于 0.0
*/
}

/**
 * 字符
 */
fun check(c: Char) {
    //if (c == 1) { // 错误：类型不兼容
    // ……
    //}
}

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

/**
 * 布尔型
 */
fun booleanType() {
    /**
    布尔用 Boolean 类型表示，它有两个值：true 和 false。
    若需要可空引用布尔会被装箱。
    内置的布尔运算有：
    || – 短路逻辑或
    && – 短路逻辑与
    ! - 逻辑非
     */
}

/**
 * 数组
 */
fun arrayType() {
    // 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
    val asc = Array(5, { i -> (i * i).toString() })

    val x: IntArray = intArrayOf(1, 2, 3)
    var byteArrayOf: ByteArray = byteArrayOf(1, 3, 4)
    x[0] = x[1] + x[2]

    val arrayOf = arrayOf(1, 2, 3, 4, 5, "3")
    //创建一个指定大小的、所有元素都为空的数组。
    val arrayOfNulls = arrayOfNulls<Int>(4)
    val size = arrayOf.size
    println("${arrayOf[1]}, $size, ${arrayOfNulls[1]}")
}

/**
 * 字符串类型
 */
fun stringType(){
    //字符串用 String 类型表示。字符串是不可变的。
    // 字符串的元素——字符可以使用索引运算符访问: s[i]。 可以用 for 循环迭代字符串:
    val str = "abcd"
    for (c in str) {
        println(c)
    }

    //可以用 + 操作符连接字符串。这也适用于连接字符串与其他类型的值，
    // 只要表达式中的第一个元素是字符串：
    val s = "abc" + 1
    println(s + "def")

    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
}