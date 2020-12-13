package operating_system;

/**
 * @author TIMI
 * @Date 2020/12/13 - 11:48
 */
public class MyLambda {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i =0;i<100;i++){
                System.out.println("子线程：" + i);
            }
        }).start();
        for(int i=0;i<100;i++){
            System.out.println("主线程：" + i);
        }
    }
}
