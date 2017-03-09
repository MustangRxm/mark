




package me.sonico.kotlin

/**
 * Created by yanfa_4 on 2016-11-14.
 */
open class Parent(k:Int) {//如果不标注open，会修饰符会含有final，无法继承
    fun add(a:Int , b:Int) :Int?{
        return a+b
    }

}