package com.kotlincn.example

/**
 *
 * Created by tao.liu on 2018/1/18.
 * 扩展
 */
fun main(args: Array<String>) {

}

/*
由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。这就是为什么扩展属性不能有初始化器。
他们的行为只能由显式提供的 getters/setters 定义。
val Foo.bar = 1 // 错误：扩展属性不能有初始化器
 */
