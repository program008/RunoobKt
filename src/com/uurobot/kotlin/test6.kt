package com.uurobot.kotlin

/**
 *
 * Created by tao.liu on 2018/1/15.
 * kotlin 继承
 */
fun main(args: Array<String>) {
        test2()
        println("---------------------------------")
        test3()
        println("---------------------------------")
        test4()
        println("----------------5-----------------")
        test5()
}

/*
---------------------------子类有主构造函数------------------------------
如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
 */

open class Person2(var name: String, var age: Int) {//基类

}

class Student(name: String, age: Int, var no: String, var score: Int) : Person2(name, age) {

}

private fun test2() {
        val s = Student("Runoob", 18, "S12346", 89)
        println("学生名： ${s.name}")
        println("年龄： ${s.age}")
        println("学生号： ${s.no}")
        println("成绩： ${s.score}")
}

/*
----------------------------子类没有主构造函数-------------------------------------
如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
 */

/**用户基类**/
open class Person3(name: String) {
        /**
         * 次级构造函数
         */
        constructor(name: String, age: Int) : this(name) {
                //初始化
                println("-------基类次级构造函数---------")
        }
}

/**子类继承 Person 类**/
class Student2 : Person3 {
        /**次级构造函数**/
        constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {
                println("-------继承类次级构造函数---------")
                println("学生名： ${name}")
                println("年龄： ${age}")
                println("学生号： ${no}")
                println("成绩： ${score}")
        }
}

private fun test3() {
        var s = Student2("Runoob", 18, "S12345", 89)
}

/*
-------------------------------------------重写----------------------------------------------------------------
在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。如果允许子类重写该函数，
那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词：
 */
/**用户基类**/
open class Person4 {
        open fun study() {//允许子类重写
                println("我毕业了")
        }
}

class Student3 : Person4() {
        override fun study() {
                println("我还没有毕业！")
//                super.study()
        }
}

private fun test4() {
        var student3 = Student3()
        student3.study()
}

/*
如果有多个相同的方法（继承或者实现自其他类，如A、B类），则必须要重写该方法，使用super范型去选择性地调用父类的实现。
 */

open class A {
        open fun f() {
                println("A")
        }

        fun a() {
                println("a")
        }
}

interface B {
        fun f() {
                println("B")
        }

        fun b(){
                println("b")
        }
}

class C():A(),B{
        override  fun f() {
                super<A>.f()//调用 A.f()
                //super<B>.f()//调用 B.f()
                println("c--f")
        }

        override fun b(){
                println("c----b")
        }
}
private fun test5(){
        var c = C()
        c.f()
        c.a()
        c.b()
}

/**
 * 属性重写
属性重写使用 override 关键字，属性必须具有兼容类型，每一个声明的属性都可以通过初始化程序或者getter方法被重写：
open class Foo {
open val x: Int get { …… }
}

class Bar1 : Foo() {
override val x: Int = ……
}
你可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
 */
interface Foo {
        val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
        override var count: Int = 0
}