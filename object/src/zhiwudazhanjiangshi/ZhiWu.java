package zhiwudazhanjiangshi;

import zhiwudazhanjiangshi.JiangShi;

/**
 * @author TIMI
 * @Date 2020/11/24 - 16:47
 */
public class ZhiWu {
    String name;
    int hp;
    int attack;
    public ZhiWu(String name,int hp,int attack){
        this.name=name;
        this.hp=hp;
        this.attack=attack;
    }
    public void fight(JiangShi js){
        System.out.println(this.name + "在干" + js.name);
        js.hp -= this.attack;
        System.out.println("僵尸剩余的血量是：" + js.hp);
    }
}
