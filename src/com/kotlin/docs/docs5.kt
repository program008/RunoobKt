package com.kotlin.docs

/**
 * Created by tao.liu on 2018/7/12.
 * 属性和字段
 */
fun main(args: Array<String>) {
    var allByDefault: Int? // 错误：需要显式初始化器，隐含默认 getter 和 setter
    var initialized = 1 // 类型 Int、默认 getter 和 setter

    val simple: Int? // 类型 Int、默认 getter、必须在构造函数中初始化
    val inferredType = 1 // 类型 Int 、默认 getter

//    val isEmpty: Boolean
//    get() = this.size == 0
//
//    var stringRepresentation: String
//    get() = this.toString()
//    set(value) {
//        setDataFromString(value) // 解析字符串并赋值给其他属性
//    }


}

class TestSubject(){

}
public class MyTest {
    lateinit var subject: TestSubject

//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // 直接解引用
//    }
}