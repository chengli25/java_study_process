package test.test1.test3;

import polymorphic.Person;

/**
 * @author TIMI
 * @Date 2020/11/24 - 20:21
 */
public class Client {
    public static void main(String[] args) {
        Player p = new Player();
       Game ga1 = new DNF();
       Game ga2 = new LOL();
       Game ga3 = new Cs();
       Game ga4 = new ChiJi();
       p.happy(ga1);
       p.happy(ga2);
       p.happy(ga3);
       p.happy(ga4);
       LOL gaa = (LOL)ga2;
       gaa.play1();
    }
}
