package bite_test;

import java.util.*;

/**
 * @author: Zero
 * @Date: 2021/4/2 - 16:29
 * @since: jdk 1.8
 */
public class MinStepToFie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> list = new HashSet<>();
        while(sc.hasNext()){
            list.add(sc.nextLine());
        }
        System.out.println(list.size());
    }

}
