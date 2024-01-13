package com.lhq.springboot3.study.lambda;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/5 21:42
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式接口： 接口中有且只有一个未实现的方法，这个接口就叫函数式接口
 * 只要是函数式接口就可以用Lambda表达式简化
 */
interface MyInterface {
    int sum(int i, int j);
}
class MyInterfaceImpl implements MyInterface {
    @Override
    public int sum(int i, int j) {
        return i + j;
    }
}

interface MyA {
    int testA();
}
@FunctionalInterface //检查注解，帮我们快速检查我们写的接口是否函数式接口
interface MyB {
    int testB(int b);
}
public class Lambda {

    public static void main(String[] args) {
        //1、有入参，无出参【消费者】：  function.accept
        BiConsumer<String,String> consumer = (a, b)->{
            System.out.println("哈哈："+a+"；呵呵："+b);
        };
        consumer.accept("1","2");

        //2、有入参，有出参【多功能函数】：   function.apply
        Function<String,Integer> function = (String x) -> Integer.parseInt(x);
        System.out.println(function.apply("2"));

        //3、无入参，无出参【普通函数】：
        Runnable runnable = () -> System.out.println("aaa");
        new Thread(runnable).start();

        //4、无入参 ，有出参【提供者】：  supplier.get()
        Supplier<String> supplier = ()-> UUID.randomUUID().toString();
        String s = supplier.get();
        System.out.println(s);


        BiFunction<String,Integer,Long> biFunction = (a, b)-> 888L;
    }
    /**
     * 表达式的使用
     * @param args
     */
    public static void b(String[] args) {
        var names = new ArrayList<String>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        //比较器
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        //直接写函数式接口就方便   (o1,o2)->o1.compareTo(o2)
        Collections.sort(names, (String o1, String o2) -> o1.compareTo(o2));
        System.out.println(names);

        // 类::方法； 引用类中的实例方法； 忽略lambda的完整写法
        Collections.sort(names,String::compareTo);
        System.out.println(names);
    }


    /**
     * lambda简化函数式接口实例创建
     *
     * @param args
     */
    public static void a(String[] args) {
        //1 实现类
        MyInterface myInterface = new MyInterfaceImpl();
        System.out.println(myInterface.sum(1,2));
        //2 匿名实现类
        MyInterface myInterface1 = new MyInterface() {
            @Override
            public int sum(int i, int j) {
                return i*i + j*j;
            }
        };
        System.out.println(myInterface1.sum(1,2));

        //3 lambda表达式
        MyInterface myInterface2 = (int i, int j) ->{
            return i*j;
        };
        System.out.println(myInterface2.sum(1,2));

        //简化写法：
        //1)、参数类型可以不写，只写(参数名)，参数变量名随意定义;
        //    参数表最少可以只有一个 ()，或者只有一个参数名；
        //2、方法体如果只有一句话，{} 可以省略
        MyInterface myInterface3 = (x, y) ->{
            return x*y;
        };
        MyA myA = () ->{
            return 1;
        };
        MyB myB = x ->{
            return x + 1;
        };
        MyB myB1 = x -> x + 1;
    }
}
