package customexception;

/**
 * @author TIMI
 * @Date 2020/11/25 - 14:53
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("张无忌","男");
        Person p2 = new Person("赵敏","女");
        ZaoTang zt = new ZaoTang();
        zt.na(p2);


    }
}
