package yield;

/**
 * @author TIMI
 * @Date 2020/11/27 - 15:28
 */
public class MyThread extends  Thread{
    public MyThread(String name){
        super.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(super.getName() + i);
            if(i%10==0){
                Thread.yield();
            }
        }
    }
}
