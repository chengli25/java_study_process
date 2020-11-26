package customexception;

import com.sun.xml.internal.bind.v2.schemagen.XmlSchemaGenerator;
import sun.reflect.generics.repository.GenericDeclRepository;

/**
 * @author TIMI
 * @Date 2020/11/25 - 14:44
 */
public class GerderException extends RuntimeException{
   //自己定义的异常必须要继承exception或者runtimeexce
    public GerderException(String msg){
        super(msg);//调用父类的构造方法，抛出的错误参数传递进去；
    }
}
