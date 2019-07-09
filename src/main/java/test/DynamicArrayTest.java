package test;

import java.lang.reflect.Array;
/**
 *	Java�ж�̬�޸�����(Array)�Ĵ�С
 */
public class DynamicArrayTest {
	 
    private static Object resizeArray (Object oldArray, int newSize) {
        //��ȡ����oldArray�ĳ���
        int oldSize = Array.getLength(oldArray);
        //��ȡ����oldArray��Ԫ������
        Class elementType = oldArray.getClass().getComponentType();
        //ʵ��һ���µ����� ���ͺ�oldArray��һ�� ���Ȳ��������newSize
        Object newArray = Array.newInstance(elementType,newSize);
        //�õ�������newArray ��oldArray�����г�����̵ģ����ѳ��ȷ��ظ�preserveLength
        int preserveLength = Math.min(oldSize,newSize);
        //�������ݸ���
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
