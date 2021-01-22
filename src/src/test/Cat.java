package test;

/**
 * @author TIMI
 * @Date 2021/1/20 - 9:16
 */
public class Cat extends Animal {
    private String sex;

    public Cat(String name, String sex) {
        super(name);
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void saojiao() {
        System.out.println(this.sex + "的小猫会撒娇");
    }

}
