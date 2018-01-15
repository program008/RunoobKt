package com.uurobot.kotlin

/**
 * kotlin 类和对象
 */
fun main(args: Array<String>) {
        var person: Person = Person()

        person.lastName = "wang"

        println("lastName:${person.lastName}")

        person.no = 9
        println("no:${person.no}")

        person.no = 20
        println("no:${person.no}")

        //person.heiht = 12.0F
        println("height ${person.heiht}")


        val runoob = Runoob("菜鸟教程", 1000)
        println(runoob.siteName)
        println(runoob.url)
        println(runoob.country)
        runoob.printTest()


        testNestClass()

        testInner()

        test2()
}

class Person {
        var lastName: String = "zhang"
                get() = field.toUpperCase()   // 将变量赋值后转换为大写
                set

        var no: Int = 100
                get() = field // 后端变量
                set(value) {
                        if (value < 10) {       // 如果传入的值小于 10 返回该值
                                field = value
                        }
                        else {
                                field = -1         // 如果传入的值大于等于 10 返回 -1
                        }
                }

        var heiht: Float = 145.4f
                private set //表示不能再复制

        val w: Int = 1
                get() = field

}
//非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
//public class MyTest {
//        lateinit var subject: TestSubject
//
//        @SetUp fun setup() {
//                subject = TestSubject()
//        }
//
//        @Test fun test() {
//                subject.method()  // dereference directly
//        }
//}


class Runoob constructor(name: String) {  // 类名为 Runoob
        // 大括号内是类体构成
        var url: String = "http://www.runoob.com"
        var country: String = "CN"
        var siteName = name

        //主构造函数
        init {
                println("初始化网站名: ${name}")
        }

        // 次构造函数
        constructor (name: String, alexa: Int) : this(name) {
                println("Alexa 排名 $alexa")
        }

        fun printTest() {
                println("我是类的函数")

        }
}


/**
 * ---------------------------------------抽象类-----------------------------------------------------
 *
 * 抽象是面向对象编程的特征之一，类本身，或类中的部分成员，都可以声明为abstract的。抽象成员在类中不存在具体的实现。
 * 注意：无需对抽象类或抽象成员标注open注解。
 */
open class Base {
        open fun f() {}
}

abstract class Derived : Base() {
        override abstract fun f()
}


/**
 * ---------------------------------------嵌套类-------------------------------------------------------
 * 我们可以把类嵌套在其他类中，看以下实例：
 */
class Outer{//外部类
        private val bar:Int = 1

        class Nested{//嵌套类
                fun f1() = 2
        }
}

fun testNestClass(){
        var i = Outer.Nested().f1()// 调用格式：外部类.嵌套类.嵌套类方法/属性
        println("嵌套类测试结果：$i")
}

/*
        -----------------------------------内部类----------------------------------------------------
        内部类使用 inner 关键字来表示。
        内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
 */

class Outer2{
        private val bar:Int = 1
        private val v = "成员属性"
        inner class Inner{//内部类
                fun f() = bar // 访问外部类成员
                fun testInner(){
                        var outer2 = this@Outer2 //获取外部类的成员变量
                        println("内部类可以引用外部类的成员，例如：" + outer2.v)
                }
        }
}

fun testInner(){
        var f = Outer2().Inner().f()
        println(f)

        var demo = Outer2().Inner().testInner()// 内部类可以引用外部类的成员，例如：成员属性
        println(demo)
}

class Test {
        var v = "成员属性"

        fun setInterFace(test: TestInterFace) {
                test.test()
        }
}

/**
 * 定义接口
 */
interface TestInterFace {
        fun test()
}

private fun test2(){
        var test = Test()

        /**
         * 采用对象表达式来创建接口对象，即匿名内部类的实例。
         */
        test.setInterFace(object : TestInterFace {
                override fun test() {
                        println("对象表达式创建匿名内部类的实例")
                }
        })


}

/**
 * 类的修饰符
类的修饰符包括 classModifier 和_accessModifier_:
classModifier: 类属性修饰符，标示类本身特性。
abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
accessModifier: 访问权限修饰符
private    // 仅在同一个文件中可见
protected  // 同一个文件中或子类可见
public     // 所有调用的地方都可见
internal   // 同一个模块中可见
 */