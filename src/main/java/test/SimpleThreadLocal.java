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
	 * KeyΪ�̶߳���ValueΪ�����ֵ����
	 */
	private static Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<Thread, Object>());

	/**
	 * ��ֵ
	 * 
	 * @param value Map��ֵ�Ե�value
	 */
	public void set(T value) {
		valueMap.put(Thread.currentThread(), value);
	}

	/**
	 * ȡֵ
	 * 
	 * @return
	 */
	public T get() {
		Thread currentThread = Thread.currentThread();
		// ���ص�ǰ�̶߳�Ӧ�ı���
		T t = (T) valueMap.get(currentThread); // �����ǰ�߳���Map�в����ڣ��򽫵�ǰ�̴߳洢��Map��
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
			params.add("����");
			params.add("����");
			params.add("����");
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
		// �̳߳ر���ָ��һ���߳�
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
