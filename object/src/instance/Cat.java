package instance;

import polymorphic.Animal;

/**
 * @author TIMI
 * @Date 2020/11/25 - 11:46
 */
public class Cat extends polymorphic.Animal {
    public static void main(String[] args) {
        polymorphic.Animal ani = new Animal();
        if(ani instanceof Cat){
            System.out.println("是一只猫，撸一撸");

        }else {
            System.out.println("不是一只猫");
        }
    }


}
