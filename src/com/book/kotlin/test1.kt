package com.book.kotlin

/**
 *
 * Created by tao.liu on 2018/1/17.
 */
fun main(args: Array<String>) {
        println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * 使用if层叠对表达式求值
 */
fun eval(e: Expr): Int {
        if (e is Num) {
                val n = e as Num //显式地转换成类型Num是多余的
                return n.value
        }

        if (e is Sum) {
                return eval(e.left) + eval(e.right) //变量e被智能地转换了类型
        }
        throw IllegalArgumentException("Unknown expression")
}

/**
 * 使用有返回值的if表达式
 */
fun eval2(e: Expr): Int =
        if (e is Num) {
                e.value
        }
        else if (e is Sum) {
                eval2(e.left) + eval2(e.right)
        }
        else {
                throw IllegalArgumentException("Unknown expression")
        }

/**
 * 使用when代替if层叠
 */
fun eval3(e: Expr): Int =
        when (e) {
                is Num -> e.value
                is Sum -> eval3(e.left) + eval3(e.right)
                else -> throw IllegalArgumentException("Unknown expression")
        }

fun evalWithLogging(e: Expr): Int =
        when (e) {
                is Num -> {
                        println("num: ${e.value}")
                        e.value
                }
                is Sum -> {
                        val left = evalWithLogging(e.left)
                        val right = evalWithLogging(e.right)
                        println("sum:$left+$right")
                        left + right

                }
                else -> throw IllegalArgumentException("Unknown expression")
        }
