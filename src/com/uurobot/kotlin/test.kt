package com.uurobot.kotlin

fun main(args: Array<String>) {
        val sum = sum(1, 2)
        var sum2 = sum2(1, 2)
        var sum3 = sum3(1, 2)
        println("$sum , $sum2 , $sum3")
        hello()
        hello2()
        vars(1, 2, 3, 4, 5, 6, 7)

        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumLambda(1, 2))  // 输出 3

        var_()

        checkNull()

        rangeTo_()
}

/**
 * 函数定义 参数 ：类型
 */
fun sum(a: Int, b: Int): Int {
        return a + b
}

/**
 * 表达式作为函数体，返回类型自动推断
 */
fun sum2(a: Int, b: Int) = a + b

fun sum3(a: Int, b: Int): Int = a + b
/**
 * 无返回值的函数(类似Java中的void)：
 * 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
 */
fun hello() {
        println("hello kotlin")
}


fun hello2(): Unit {
        println("hello kt")
}

/**
 * 可变长参数
 */
fun vars(vararg v: Int) {
        for (i in v) {
                print(i)
        }
        println()
}

/**
 * 可变变量定义：var 关键字
 * var <标识符> : <类型> = <初始化值>
 * 不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
 * val <标识符> : <类型> = <初始化值>
 */
fun var_() {
        val a: Int = 1  //类型可以省去
        val b = 1       // 系统自动推断变量类型为Int
        val c: Int      // 如果不在声明时初始化则必须提供变量类型
        c = 1           // 明确赋值

        var x = 5        // 系统自动推断变量类型为Int
        x += 1 // 变量可修改

        println(a)
        println(b)
        println(c)
        println(x)

        var e: Int = 1
        e += 1

        val f: Int = 1
        //f += 1 val can not be reassigned
}

/**
 * NULL检查机制
 */
fun checkNull() {
        //类型后面加?表示可为空

        var age: String? = "33"
        //抛出空指针异常
        //val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
        //age为空返回-1
        val ages2 = age?.toInt() ?: -1

        //val ages3 = age.toInt()

        //println(ages)
        println(ages1)
        println(ages2)
        //println(ages3)

        var int = parseInt("33")
        println(int)

        println(getStringLength("hello"))
        println(getStringLength(9))

        val name: String? = null    // Nullable type
        //println(name.length())      // Compilation error


}

/**
 * 当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null。
 * 当 str 中的字符串内容不是一个整数时, 返回 null:
 */
fun parseInt(str: String?): Int? {
        return str?.toInt()
}

/**
 * 我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
 */
fun getStringLength(obj: Any): Int? {
        if (obj is String) {
                // 做过类型判断以后，obj会被系统自动转换为String类型
                return obj.length
        }

        //在这里还有一种方法，与Java中instanceof不同，使用!is
         if (obj !is String){
           // XXX
         }

        if (obj is Int){
                return null;
        }

        // 这里的obj仍然是Any类型的引用
        return null
}

fun  rangeTo_(){
        println("---------------")
        for (i in 1..5) println(i)
        for (i in 5..1) println(i) //什么都不输出

        for (i in 1..100){// i in [1,100]
                if (i in 10..14) println(i)
        }
        // 使用 step 指定步长
        for (i in 1..10 step 2){
                println(i)
        }
        //倒序遍历 步长2
        for (i in 10 downTo 1 step 2){
                println(i)
        }
        println("---------------")
        // 使用 until 函数排除结束元素
        for (i in 1 until 10){ // i in [1, 10) 排除了 10
                println(i)
        }
}

/*class Car{}
private fun test1(){
        if (object is Car) {
        }
        var car = object as Car
}*/
