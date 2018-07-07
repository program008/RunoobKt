package com.kotlincn.example

/**
 *
 * Created by tao.liu on 2018/1/22.
 * 集合
 */
fun main(args: Array<String>) {
        test()

        test2()
}

private fun test() {
        val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
        val readOnlyView: List<Int> = mutableList
        println(readOnlyView)
        mutableList.add(4)
        println(readOnlyView)
        //可变集合和不可变集合的区别
        //readOnlyView.clear() // -> 不能编译
        mutableList.clear()

        var hashSetOf = hashSetOf("a", "c", "b", "a")
        println(hashSetOf.size)
}

private fun test2(){
        val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
        println(readWriteMap["foo"])  // 输出“1”
        val snapshot: Map<String, Int> = HashMap(readWriteMap)
        println(snapshot)
}