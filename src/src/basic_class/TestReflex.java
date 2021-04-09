package basic_class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TIMI
 * @Date 2021/2/21 - 19:16
 */

public class TestReflex {
     //构造方法
     public TestReflex() throws ClassNotFoundException {
     }



     //Class方法测试
     public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
         //获取class的三种方式
         //方式一:适用于传送过来的是一个object类，而程序员不知道具体是什么类的情况
         person p1 = new person();
         Class c1 = p1.getClass();
         //方式二：通过类型.class的方式得到，方法安全可靠，程序性高
         Class c2 = person.class;
         //方式三：通过Class对象的forname()静态方法来获取，使用的最多；但可能会抛出classNotFoundexception异常
         Class c3 = Class.forName("basic_class.person");


         /**
          * getName（）测试
          */
         //getName()测试(获取公共字段)
         String classname = c2.getName();
         System.out.println("获取类名：" + classname);


         /**
          * getField()测试（获取公共属性,获取指定属性）
          */
         //getField()测试(获取共有属性)
         Field[] fields = c1.getFields();
         for(Field field1 : fields) {
             //根据字段获取值
             System.out.println("获取公有字段名：" + field1.getName());
             }
         //获取指定属性
         Field f1 = c2.getField("age");
         System.out.println("获取指定字段名：" + f1);


         /**
          * getDeclareFields()测试（获取所有属性）
          */
         Field[] allfields = c2.getDeclaredFields();
         for(Field field : allfields) {
             System.out.println("获取所有字段名：" + field.getName());
         }
         Field f2 = c3.getDeclaredField("name");
         f2.setAccessible(true);
         System.out.println("私有属性：" + f2);

         /**
          * getMethods()测试（获取共有方法）
          */
         Method[] methods = c2.getMethods();
         for(Method method : methods) {
             method.setAccessible(true);
             System.out.println("获取共有方法名：" + method.getName() + "\n");
         }

         /**
          * getDeclareFields()测试（获取所有方法）
          */
         Method[] allmethods = c2.getDeclaredMethods();
         for(Method method : allmethods) {
             /**
              * 启用和禁用安全检查开关，值为true
              */
             method.setAccessible(true);
             System.out.println("获取所有方法名：" + method.getName());
             System.out.println();
         }


         /**
          * getConstructor()测试（获取public构造方法）
          */
         Constructor[] constructors = c2.getConstructors();
         for(Constructor constructor : constructors) {
             System.out.println("获取构造方法：" + constructor.toString());
         }
     }


}








class person {
    //私有属性
    private String name = "Tom";
    //公有属性
    public int age = 18;

    public person() {

    }

    //私有方法
    private void say(){
        System.out.println("private say()...");
    }

    //公有方法
    public void work(){
        System.out.println("public work()...");
    }
}
