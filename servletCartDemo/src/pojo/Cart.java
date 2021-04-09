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
    private HashMap<Items,Integer> goods;//商品
    private Double totalPrice;//总价

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

    //添加商品进购物车
    public boolean addGoodsInCart(Items items,int num) {
        //处理是不是第一次购买商品，如果是，那么goods里面不包含items，否则，那么只需要在原有商品的基础上加上购买的数量
        if(goods.containsKey(items)) {
            goods.put(items,goods.get(items) + num);
        } else {
            goods.put(items,num);
        }
        calTotalPrice();//重新计算购物车的总金额
        return true;
    }
    //删除商品
    public boolean removeGoodsFromCart(Items items) {
        goods.remove(items);
        calTotalPrice();
        return true;
    }
    //统计总金额
    public double calTotalPrice() {
        double sum = 0.0;
        Set<Items> set = goods.keySet();//获取键的集合
        Iterator<Items> it = set.iterator();
        while(it.hasNext()) {
            Items i = it.next();
            sum += i.getPrice() * goods.get(i);
        }
        this.setTotalPrice(sum);//设置购物车的总金额
        return this.getTotalPrice();
    }

    public static void main(String[] args) {
        Items it = new Items(1,"篮球鞋","泉州",200,500,"001,jpg");
        Items it2 = new Items(2,"李宁运动鞋","泉州",300,400,"002,jpg");
        Items it3 = new Items(2,"李宁运动鞋","泉州",300,400,"002,jpg");

        Cart c = new Cart();
        c.addGoodsInCart(it,1);
        c.addGoodsInCart(it2,2);
        c.addGoodsInCart(it3,3);
        System.out.println("购物车的总金额是：" + c.getTotalPrice());

        //遍历购物商品的集合
        Set<Map.Entry<Items,Integer>> item = c.getGoods().entrySet();
        for(Map.Entry<Items,Integer> obj:item){
            System.out.println(obj);
        }
    }
}
