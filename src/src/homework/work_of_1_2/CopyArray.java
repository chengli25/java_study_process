package homework.work_of_1_2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2021/1/2 - 20:03
 */
public class CopyArray {
    public static void main(String[] args) {
        int[] a = {1,23,543,543,6,43,7,4,2,432,51,12};
        int[] b = coppyArray(a);
        System.out.println("数组a: " + Arrays.toString(a));
        System.out.println("数组b：" + Arrays.toString(b));
    }


    public static int[] coppyArray(int[] a) {
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        return b;
    }
}
