package com.goat.example02;


import org.testng.annotations.Test;

import java.lang.reflect.*;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---18:56
 *
 */
public class MyReflect2 {

    /**
         * @Description:  获取class的三种方式
         * @author: 杨帆
            第一种：通过Object类的getClass方法  Class cla = foo.getClass();
            第二种：通过对象实例方法获取对象  Class cla = foo.class;
            第三种：通过Class.forName方式   Class cla = Class.forName("xx.xx.Foo");
    */
    @Test
    public void test0() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("MyReflect.example02.Dog");
        System.out.println(aClass);
    }
    @Test
    public void test1() {
        Dog dog = new Dog("hahagou",12);
        Class<? extends Dog> aClass = dog.getClass();
        System.out.println(aClass);
    }
    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        Class<Dog> dogClass = Dog.class; //
        Dog dog = dogClass.newInstance(); // 通过class对象 调用默认无参构造函数 来 实例化类对象  （如果没有提供无参构造方法 则会报错）
        System.out.println(dog.getName());
        System.out.println(dog.getAge());
        System.out.println(dog.married);
    }
    @Test
    public void test3() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors(); // 获取 指定类的所有构造函数
        Constructor<Dog> constructor1 = dogClass.getConstructor(String.class, Integer.class); // 获取指定构造函数

        Dog dog1 = constructor1.newInstance("山羊来了111", 111); // 使用反射获取指定构造函数 来创建类对象
        System.out.println(dog1.toString());

        Constructor<Dog> constructor2 = dogClass.getConstructor(); // 获取无参造函数
        Dog dog2 = constructor2.newInstance(); // 使用无参构造函数 来创建类对象
        System.out.println(dog2.toString());
    }

    @Test
    public void test4()  {
        Class<Dog> dogClass = Dog.class;
        Field[] publicfields1 = dogClass.getFields();  // 该方法只能获取 类中 public属性  private属性是获取不到的！
        getDeclaredFields(dogClass);
    }

    public static void getDeclaredFields(Class<?> aClass) {
        Field[] allfields1 = aClass.getDeclaredFields();  // 该方法 可以获取类中的所有属性   无论公有还是私有
        for (int i = 0; i < allfields1.length; i++) {
            int modifiers = allfields1[i].getModifiers();
            System.out.println(Modifier.toString(modifiers) + allfields1[i].getName());// 获取 属性修饰符 + 属性名称
        }
    }

    @Test
    public void test5() throws IllegalAccessException,  InvocationTargetException {
        Class<Dog> dogClass = Dog.class;
        Package aPackage = dogClass.getPackage();// 获取类所在包名
        System.out.println(aPackage.getName());
        Method[] methods = dogClass.getMethods(); // 获取类中的所有公有方法 和继承的公有方法  私有和protect 是获取不到的
        for(Method method:methods){
            System.out.println(method.getName());
            if(method.getName().equals("toString")){
                Object invoke = method.invoke(new Dog("wowo",53)); // 通过反射 调用类中公有的方法
                System.out.println(invoke);
            }
        }
    }
    @Test
    public void test6() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Class<?> aClass = Class.forName("MyReflect.example02.Dog");
        Method[] declaredMethods = aClass.getDeclaredMethods(); // 获取 本类中定义的方法  包括 私有和公有 但不包括父类的
        for(Method method:declaredMethods){  // 遍历对象中的所有方法
            System.out.println(method.getName());
            if(method.getName().equals("fuck")){ // 判断出指定方式
                method.setAccessible(true); // 设置权限  使其可以访问 类中的私有方法  否则 报权限错误
                method.invoke(new Dog()); // 通过反射 调用类中的方法
            }
        }
    }

}