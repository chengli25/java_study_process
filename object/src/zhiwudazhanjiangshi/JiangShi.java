package zhiwudazhanjiangshi;

/**
 * @author TIMI
 * @Date 2020/11/24 - 16:49
 */
public class JiangShi {
    String name;
    int hp;
    int attack;
    public JiangShi(String name,int hp,int attack){
        this.name = name;
        this.hp=hp;
        this.attack=attack;
    }
    public void eat(ZhiWu zw){
        System.out.println(this.name + "正在吃" + zw.name);
        zw.hp -= this.attack;
        System.out.println("植物的血量还有：" + zw.hp);
    }
}
