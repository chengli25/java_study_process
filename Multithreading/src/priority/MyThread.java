package priority;

/**
 * @author TIMI
 * @Date 2020/11/27 - 14:31
 */
public class MyThread extends Thread {
    public MyThread(String name){
        super.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(super.getName() + "==>"+ i );

        }
    }
}
