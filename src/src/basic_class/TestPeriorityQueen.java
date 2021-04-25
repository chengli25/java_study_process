package basic_class;

import java.util.PriorityQueue;

/**
 * @author: Zero
 * @Date: 2021/3/20 - 15:29
 * @since: jdk 1.8
 */
class boy implements Comparable<boy>{
    private String name;
    private String gender;
    private int age;

    public boy(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "boy{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(boy o) {
        if(this.name.compareTo(o.name) >= 0){
            System.out.println();
            return 1;
        }
        else if(this.name.compareTo(o.name) < 0){
            return -1;
        }
        return 0;
    }
}
public class TestPeriorityQueen {
    public static void main(String[] args) {
        PriorityQueue<boy> priorityQueue = new PriorityQueue<boy>();
            priorityQueue.offer(new boy("a","m",19));
            priorityQueue.offer(new boy("h","e",22));
            priorityQueue.offer(new boy("f","w",54));
            priorityQueue.offer(new boy("b","b",14));
            for(boy b : priorityQueue) {
                System.out.println(b);
            }
    }

}
