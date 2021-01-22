package test;

/**
 * @author TIMI
 * @Date 2021/1/20 - 9:21
 */
public class Bird extends Animal {
    private String sex;
    public Bird(String name,String sex) {
        super(name);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void fly() {
        System.out.println(this.sex + "的小鸟会飞");
    }
}
