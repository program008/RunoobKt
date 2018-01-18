package com.kotlincn.example

/**
 *
 * Created by tao.liu on 2018/1/18.
 * 枚举类
 */

fun main(args: Array<String>) {
        test1()
}

enum class Direction {
        NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
}

enum class ProtocolState {
        WAITING {
                override fun signal() = TALKING
        },

        TALKING {
                override fun signal() = WAITING
        };

        abstract fun signal(): ProtocolState
}

enum class RGB { RED, GREEN, BLUE }

/**
 *
 * 使用枚举常量
 * 就像在 Java 中一样，Kotlin 中的枚举类也有合成方法允许列出定义的枚举常量以及通过名称获取枚举常量。
 * 这些方法的签名如下（假设枚举类的名称是 EnumClass）：
 * EnumClass.valueOf(value: String): EnumClass
 * EnumClass.values(): Array<EnumClass>
 * 如果指定的名称与类中定义的任何枚举常量均不匹配，valueOf() 方法将抛出 IllegalArgumentException 异常。
 * 自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量 ：
 *
 *
 */
inline fun <reified T : Enum<T>> printAllValues() {
        print(enumValues<T>().joinToString { it.name })
}

/**
 * 每个枚举常量都具有在枚举类声明中获取其名称和位置的属性：
 * val name: String
 * val ordinal: Int
 */
private fun test1(){
        printAllValues<RGB>() // 输出 RED, GREEN, BLUE
        var enumValueOf = enumValueOf<RGB>("BLUE")
        //Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.kotlincn.example.RGB.RGB
        println()
        println("enumValueOf = $enumValueOf, ${enumValueOf.name}, ${enumValueOf.ordinal}")

        var enumValues = enumValues<Direction>()
        println("enumValues = ${enumValues.joinToString { it.name }}")

}