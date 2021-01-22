package test;

/**
 * @author TIMI
 * @Date 2021/1/20 - 9:15
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(Animal ani) {
        System.out.println( ani.getName() + "正在吃");
    }
}
