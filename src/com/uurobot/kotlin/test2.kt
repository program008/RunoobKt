package com.uurobot.kotlin

fun defineType() {
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010

        println(oneMillion)
        println(creditCardNumber)
        println(socialSecurityNumber)
        println(hexBytes)
        println(bytes)

        /**
         * Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，
         * 这样可以保证不会出现空指针。数字类型也一样，所有在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。
         * 在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
         */
        val a: Int = 10000
        println(a === a) // true，值相等，对象地址相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了装箱，但是值是相等的，都是10000
        println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA) // true，值相等

        /**
         * 由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。
         * 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
         * toByte(): Byte
         * toShort(): Short
         * toInt(): Int
         * toLong(): Long
         * toFloat(): Float
         * toDouble(): Double
         * toChar(): Char
         */
        val b: Byte = 1 // OK, 字面值是静态检测的
        //val i: Int = b // 错误
        val i: Int = b.toInt()

        /**
         * 有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型
         * 而且数学操作符会做相应的重载。例如下面是正确的：
         */
        val l = 1L + 3 // Long + Int => Long

        /**
         * 位操作符
         * 对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
         * shl(bits) – 左移位 (Java’s <<)
         * shr(bits) – 右移位 (Java’s >>)
         * ushr(bits) – 无符号右移位 (Java’s >>>)
         * and(bits) – 与
         * or(bits) – 或
         * xor(bits) – 异或
         * inv() – 反向
         */
        println("位操作符")
        var a1 = 10
        var a2 = 2
        //左移
        var shl = a1.shl(a2)
        println(shl)
        //右移
        var shr = a1.shr(a2)
        println(shr)
        //无符号右移
        var ushr = a1.ushr(a2)
        println(ushr)

        var and = a1.and(a2)
        println(and)

        var or = a1.or(a2)
        println(or)

        var xor = a1.xor(a2)
        println(xor)
        var inv = a1.inv()
        println(inv)

}

fun main(args: Array<String>) {
        defineType()
}