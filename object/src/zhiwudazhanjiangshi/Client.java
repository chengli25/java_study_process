package zhiwudazhanjiangshi;

import test.test1.test2.ConstructorAndOverLoading;
/**
 * @author TIMI
 * @Date 2020/11/24 - 16:58
 */
public class Client {
    public static void main(String[] args) {
        ZhiWu zw = new ZhiWu("豌豆",1000,5);
        JiangShi js = new JiangShi("铁桶僵尸",800,20);
        zw.fight(js);
        js.eat(zw);
        ConstructorAndOverLoading c = new ConstructorAndOverLoading("概论","速度放缓","ssdjl","sjfs","jsdgl;");

    }

}
