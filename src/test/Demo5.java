package test;

/*
 单例设计模式：保证一个类在内存中只有一个对象。

 模式：模式就是解决 一类 问题的固定步骤 。

 模式的概念最早起源于建筑行业....

 建房子的步骤都是一样子：

 打地基-----> 浇柱子------->盖楼面--------->砌墙--------->封顶---->装修-----入住

 软件行业中23种设计模式：

 单例设计模式
 模板设计模式
 装饰者设计模式
 观察者设计模式
 工厂设计模式

 单例设计模式的步骤：	


 饿汉单例设计模式
 1. 私有化构造函数。
 2. 声明本类的引用类型变量，并且使用该变量指向本类对象。
 3. 提供一个公共静态的方法获取本类的对象。

 懒汉单例设计模式：
 1. 私有化构造函数。
 2. 声明本类的引用类型变量，但是不要创建对象，
 3. 提供公共静态 的方法获取本类 的对象，获取之前先判断是否已经创建了本类 对象
 ，如果已经创建了，那么直接返回对象即可，如果还没有创建，那么先创建本类的对象，
 然后再返回。


 推荐使用： 饿汉单例设计模式。  因为懒汉单例设计模式会存在线程安全问题，目前还不能保证一类在内存中只有一个对象。


 */

//饿汉单例设计模式 ----> 保证Single在在内存中只有一个对象。
class Single {

	// 声明本类的引用类型变量，并且使用该变量指向本类对象
	private static Single s = new Single();

	// 私有化构造函数
	private Single() {
	}

	// 提供一个公共静态的方法获取本类的对象
	public static Single getInstance() {
		return s;
	}
}

// 懒汉单例设计模式 ----> 保证Single在在内存中只有一个对象。

class Single2 {

	// 声明本类的引用类型变量，不创建本类的对象
	private static Single2 s;

	// 私有化了构造函数
	private Single2() {
		
	}

	//
	public static Single2 getInstance() {
		if (s == null) {
			s = new Single2();
		}
		return s;
	}
}

class Demo5 {
	public static void main(String[] args) {
		Single2 s1 = Single2.getInstance();
		Single2 s2 = Single2.getInstance();
		System.out.println("是同一个对象吗？" + (s1 == s2));

	}
}
