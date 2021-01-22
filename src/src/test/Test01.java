package test;

/**
 * @author TIMI
 * @Date 2021/1/20 - 9:32
 */
public class Test01 {
    public static void main(String[] args) {
        //向上转型
        Animal ani1 = new Cat("小猫", "母");
        Animal ani2 = new Bird("小鸟", " 公");
        ani1.eat(ani1);
        ani2.eat(ani2);
        //向下转型
        Cat cat = (Cat) ani1;
        cat.saojiao();
        Bird br = (Bird) ani2;
        br.fly();
    }
}
