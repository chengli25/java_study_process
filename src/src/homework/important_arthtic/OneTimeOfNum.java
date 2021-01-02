package homework.important_arthtic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author TIMI
 * @Date 2020/12/19 - 22:36
 */
public class OneTimeOfNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,4,3,2,1};
        HashMap<Integer, Boolean> hashmap = new HashMap<>();
        Set<Integer> hashset = new HashSet<>();
        //将每个数值作为关键字添加进入一个map集合中，如果重复出现就将它的值设置成true
        for (int i = 0; i < arr.length; i++) {
            if(!hashmap.containsKey(arr[i])){
                hashmap.put(arr[i],false);
            }else {
                hashmap.put(arr[i],true);
            }
        }
        //将这个map中的关键字作为一个set集合返回，如果set中的某个值对应值为false说明只出现一次
        hashset = hashmap.keySet();
        for(Integer i:hashset){
            if(hashmap.get(i)==false){
                System.out.println(i);
            }
        }

    }
}
