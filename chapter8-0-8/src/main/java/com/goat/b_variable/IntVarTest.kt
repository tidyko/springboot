

/**
 * Description:<br>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0<br>
 */
fun main(args: Array<String>) {
    // int �ͱ���
	var a = 56
    // Long �ͱ���
	var bigValue2 = 2999999999
	println(a)
	println(bigValue2)
	println(Short.MIN_VALUE)
	println(Short.MAX_VALUE)

	// Int�ͱ�����֧��nullֵ��������������Ǵ����
//	var notNull: Int = null
	// Int?�൱��֧��nullֵ��Int�ͣ����������������ȷ��
	var nullable: Int? = null

	var pm1 = 200 // pm1��������Java��int����
	var ob1: Int? = 100 // ob1��������Java��Integer����

    println(nullable)
    println(pm1)
    println(ob1)
}