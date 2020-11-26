package polymorphic;

/**
 * @author TIMI
 * @Date 2020/11/24 - 19:54
 */
public class Cat extends Animal {
    public void eat(){

        System.out.println("猫吃鱼");
        super.eat();
    }

}
