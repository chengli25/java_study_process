package test.test1.test2;

/**
 * @author TIMI
 * @Date 2020/11/24 - 15:57
 */
public class ConstructorAndOverLoading {
    String name;
    String skill_q;
    String skill_w;
    String skill_e;
    String skill_r;
    public ConstructorAndOverLoading(String name){
        this.name=name;
    }
    public ConstructorAndOverLoading(String name,String skill_q,String skill_w,String skill_e,String skill_r){
        this(name);
        this.skill_e=skill_e;
        this.skill_q=skill_q;
        this.skill_w=skill_w;
        this.skill_r=skill_r;
    }

    public void fight(){
        System.out.println(this.name + "正在上阵杀敌！");
    }

    public static void main(String[] args) {
        ConstructorAndOverLoading hero = new ConstructorAndOverLoading("盖伦","攻击","防御","小宝剑","大宝剑");
        hero.fight();
    }

}
