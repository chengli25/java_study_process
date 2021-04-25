package bite_test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNext()){
            set.add(scanner.next());
        }
        System.out.println(set.size());
        scanner.close();
    }
}
