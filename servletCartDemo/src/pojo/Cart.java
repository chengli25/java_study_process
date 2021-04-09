package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: Zero
 * @Date: 2021/3/15 - 16:40
 * @since: jdk 1.8
 */
public class Cart {
    private HashMap<Items,Integer> goods;//��Ʒ
    private Double totalPrice;//�ܼ�

    public Cart() {
        goods = new HashMap<Items, Integer>();
        totalPrice = 0.0;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //�����Ʒ�����ﳵ
    public boolean addGoodsInCart(Items items,int num) {
        //�����ǲ��ǵ�һ�ι�����Ʒ������ǣ���ôgoods���治����items��������ôֻ��Ҫ��ԭ����Ʒ�Ļ����ϼ��Ϲ��������
        if(goods.containsKey(items)) {
            goods.put(items,goods.get(items) + num);
        } else {
            goods.put(items,num);
        }
        calTotalPrice();//���¼��㹺�ﳵ���ܽ��
        return true;
    }
    //ɾ����Ʒ
    public boolean removeGoodsFromCart(Items items) {
        goods.remove(items);
        calTotalPrice();
        return true;
    }
    //ͳ���ܽ��
    public double calTotalPrice() {
        double sum = 0.0;
        Set<Items> set = goods.keySet();//��ȡ���ļ���
        Iterator<Items> it = set.iterator();
        while(it.hasNext()) {
            Items i = it.next();
            sum += i.getPrice() * goods.get(i);
        }
        this.setTotalPrice(sum);//���ù��ﳵ���ܽ��
        return this.getTotalPrice();
    }

    public static void main(String[] args) {
        Items it = new Items(1,"����Ь","Ȫ��",200,500,"001,jpg");
        Items it2 = new Items(2,"�����˶�Ь","Ȫ��",300,400,"002,jpg");
        Items it3 = new Items(2,"�����˶�Ь","Ȫ��",300,400,"002,jpg");

        Cart c = new Cart();
        c.addGoodsInCart(it,1);
        c.addGoodsInCart(it2,2);
        c.addGoodsInCart(it3,3);
        System.out.println("���ﳵ���ܽ���ǣ�" + c.getTotalPrice());

        //����������Ʒ�ļ���
        Set<Map.Entry<Items,Integer>> item = c.getGoods().entrySet();
        for(Map.Entry<Items,Integer> obj:item){
            System.out.println(obj);
        }
    }
}
