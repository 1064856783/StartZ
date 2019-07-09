package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadLocal<T> {
	/**
	 * Key为线程对象，Value为传入的值对象
	 */
	private static Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<Thread, Object>());

	/**
	 * 设值
	 * 
	 * @param value Map键值对的value
	 */
	public void set(T value) {
		valueMap.put(Thread.currentThread(), value);
	}

	/**
	 * 取值
	 * 
	 * @return
	 */
	public T get() {
		Thread currentThread = Thread.currentThread();
		// 返回当前线程对应的变量
		T t = (T) valueMap.get(currentThread); // 如果当前线程在Map中不存在，则将当前线程存储到Map中
		if (t == null && !valueMap.containsKey(currentThread)) {
			t = initialValue();
			valueMap.put(currentThread, t);
		}
		return t;
	}

	public void remove() {
		valueMap.remove(Thread.currentThread());
	}

	public T initialValue() {
		return null;
	}

	public static void main1(String[] args) {
		SimpleThreadLocal<List<String>> threadLocal = new SimpleThreadLocal<>();
		new Thread(() -> {
			List<String> params = new ArrayList<>(3);
			params.add("张三");
			params.add("李四");
			params.add("王五");
			threadLocal.set(params);
			System.out.println(Thread.currentThread().getName());
			threadLocal.get().forEach(param -> System.out.println(param));
		}).start();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				List<String> params = new ArrayList<>(2);
				params.add("Chinese");
				params.add("English");
				threadLocal.set(params);
				System.out.println(Thread.currentThread().getName());
				threadLocal.get().forEach(param -> System.out.println(param));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
	private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
	private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>(); 
	
	public static void main(String[] args) {
		// 线程池变量指定一个线程
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.execute(() -> {
			threadLocal1.set("123");
			threadLocal2.set("234");
			threadLocal3.set("345");
			Thread t = Thread.currentThread();
			System.out.println(Thread.currentThread().getName());
		});
		
	}

}
