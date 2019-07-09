package test;

import java.lang.reflect.Array;
/**
 *	Java中动态修改数组(Array)的大小
 */
public class DynamicArrayTest {
	 
    private static Object resizeArray (Object oldArray, int newSize) {
        //获取数组oldArray的长度
        int oldSize = Array.getLength(oldArray);
        //获取数组oldArray的元素类型
        Class elementType = oldArray.getClass().getComponentType();
        //实例一个新的数组 类型和oldArray的一样 长度参数传入的newSize
        Object newArray = Array.newInstance(elementType,newSize);
        //得到新数组newArray 和oldArray两个中长度最短的，并把长度返回给preserveLength
        int preserveLength = Math.min(oldSize,newSize);
        //数组内容复制
        if (preserveLength > 0) {
            System.arraycopy (oldArray, 0, newArray, 0, preserveLength);
        }
        return newArray;
    }
 
    public static final void main(String... args) throws Exception {
        int[] a = {1,2,3};
        a = (int[])resizeArray(a,5);
        a[3] = 4;
        a[4] = 5;
        for (int i=0; i<a.length; i++) {
            System.out.println (a[i]);
        }
    }
}
