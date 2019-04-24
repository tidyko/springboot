package A04;


public class FinalVariableTest {

	final int a = 6; 	// 定义成员变量时指定默认值，合法。
	// 下面变量将在构造器或初始化块中分配初始值
	final String str;
	final int c;
	final static double d;

	// ch实例变量 既没有指定默认值，又没有在初始化块、构造器中指定初始值，不合法
//	 final char ch;
	// 初始化块，可对没有指定默认值的实例变量指定初始值
	{
		//在初始化块中为实例变量指定初始值，合法
		str = "Hello";
		// 定义a实例变量时已经指定了默认值，不能为a重新赋值，因此下面赋值语句非法
        //a = 9;
	}
	// 静态初始化块，可对没有指定默认值的类变量指定初始值
	static {
		// 在静态初始化块中为类变量指定初始值，合法
		d = 5.6;
	}
	// 构造器，可对既没有指定默认值、有没有在初始化块中
	// 指定初始值的实例变量指定初始值
	public FinalVariableTest(){
		// 如果在初始化块中已经对str指定了初始化值，
		// 构造器中不能对final变量重新赋值，下面赋值语句非法
//		 str = "java";
		c = 5;
	}

	public void changeFinal(){
//		 d = 1.2; // 普通方法不能为final修饰的成员变量赋值
//		 ch = 'a'; // 不能在普通方法中为final成员变量指定初始值
	}



}