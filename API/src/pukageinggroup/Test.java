package pukageinggroup;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author TIMI
 * @Date 2020/11/26 - 8:30
 */
public class Test {


    public static void main(String[] args) {
        //字符串转化为基本类型的唯一方式(但是字符串不能转换为字符)
        String a = "1";
        String b = "100";
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        System.out.println(c + d);
        String a1 = "12.4";
        Double b2 = Double.parseDouble(a1);
        System.out.println(b2);
    }
}
