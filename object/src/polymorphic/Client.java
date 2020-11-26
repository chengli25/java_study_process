package polymorphic;

/**
 * @author TIMI
 * @Date 2020/11/24 - 20:00
 */
public class Client {
    public static void main(String[] args) {
        Person p = new Person();
        Animal ani1 = new Cat();
        Animal ani2 = new Dog();

        p.feed(ani1);
        p.feed(ani2);


    }
}
