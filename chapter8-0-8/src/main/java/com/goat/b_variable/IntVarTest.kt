

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0<br>
 */
fun main(args: Array<String>) {
    // int 型变量
	var a = 56
    // Long 型变量
	var bigValue2 = 2999999999
	println(a)
	println(bigValue2)
	println(Short.MIN_VALUE)
	println(Short.MAX_VALUE)

	// Int型变量不支持null值，所以下面代码是错误的
//	var notNull: Int = null
	// Int?相当于支持null值的Int型，所以下面代码是正确的
	var nullable: Int? = null

	var pm1 = 200 // pm1的类型是Java的int类型
	var ob1: Int? = 100 // ob1的类型是Java的Integer类型

    println(nullable)
    println(pm1)
    println(ob1)
}