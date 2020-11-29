package homework;

import homework.Ticket;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author TIMI
 * @Date 2020/11/28 - 16:05
 */
public class TableThread extends Thread{
    private static AtomicInteger i = new AtomicInteger();

    private List<Ticket> ticketList;
    public TableThread(List<Ticket> ticketList,String name){
        this.ticketList = ticketList;
        super.setName(name);
    }
    @Override
    public void run() {
        while(true){
            if(i.get() + 4 < ticketList.size()) {
                try {
                    Thread.sleep(new Random().nextInt(150));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Ticket t = ticketList.get(i.incrementAndGet());
                System.out.println(this.getName() + "卖出：" + t.getName());
            }else {
                System.out.println("卖完了！");
                break;
            }
        }

    }
}
