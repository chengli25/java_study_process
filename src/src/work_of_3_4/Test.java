package work_of_3_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Linduse
 * @Date: 2021/3/4 - 20:32
 * @since: jdk 1.8
 */
public class Test {
    public static List list = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test t = new Test();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        //打印List
        printList(list);
        //找到最后一个节点
        findLastNode(list);
        //找到倒数第二个节点
        findPreOfLastNode(list);
        //统计个数
        int count1 = numNode(list);
        System.out.println("链表的长度为：" + count1);
        //是否包含某个节点
        int node = sc.nextInt();
        boolean bl = isContainNode(list, node);
        System.out.println("是否存在  " + bl);
        //找到第n个节点
        System.out.println("请输入需要查找第几个节点：");
        int id = sc.nextInt();
        findNodeById(id,list);

    }

    public static boolean isContainNode(List list, int node) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            if(it.next().equals(node)) {
                return true;
            }
        }
        return false;
    }

    public static int numNode(List list) {
        Iterator it = list.iterator();
        int count1 = 0;
        while(it.hasNext()) {

            count1++;
            it.next();
        }
        return count1;
    }

    public static void findNodeById(int id, List list) {
        //System.out.println(list.get(id - 1));
        int i = 1;
        Iterator it = list.iterator();
        while(it.hasNext() && i < id) {
            it.next();
            i++;
        }
        System.out.println(it.next());
    }

    public static void findPreOfLastNode(List list) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Object id = it.next();
            while(it.hasNext()) {
                Object id1 = it.next();
                if(it.hasNext()) {
                    break;
                } else {
                    System.out.println("倒数第二个节点是：" + id);
                }
            }
        }
    }

    public static void findLastNode(List list) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Object id = it.next();
            if(it.hasNext()) {
                continue;
            } else {
                System.out.println("最后一个节点是：" + id);
            }
        }
    }

    public static void printList(List list) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
