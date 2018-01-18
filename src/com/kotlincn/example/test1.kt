package com.kotlincn.example

/**
 *
 * Created by tao.liu on 2018/1/18.
 *
 * 可见性修饰符
 */
fun main(args: Array<String>) {

}
/*
--------------------------------包------------------------------
--如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见；
--如果你声明为 private，它只会在声明它的文件内可见；
--如果你声明为 internal，它会在相同模块内随处可见；
--protected 不适用于顶层声明。


------------------------------类和接口------------------------------

对于类内部声明的成员：
private 意味着只在这个类内部（包含其所有成员）可见；
protected—— 和 private一样 + 在子类中可见。
internal —— 能见到类声明的 本模块内 的任何客户端都可见其 internal 成员；
public —— 能见到类声明的任何客户端都可见其 public 成员。
注意 对于Java用户：Kotlin 中外部类不能访问内部类的 private 成员。

如果你覆盖一个 protected 成员并且没有显式指定其可见性，该成员还会是 protected 可见性。
 */