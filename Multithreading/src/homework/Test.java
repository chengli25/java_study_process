package homework;

import homework.TableThread;
import homework.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TIMI
 * @Date 2020/11/28 - 13:11
 */
public class Test {
    public static void main(String[] args) {
        List<Ticket>ticketList = new ArrayList<Ticket>();
        for (int i = 0; i < 1000; i++) {
            Ticket t = new Ticket(i,"火车票" + i);
            ticketList.add(t);
        }
        //创建窗口
        TableThread t1 = new TableThread(ticketList,"窗口一");
        TableThread t2 = new TableThread(ticketList,"窗口二");
        TableThread t3 = new TableThread(ticketList,"窗口三");
        TableThread t4 = new TableThread(ticketList,"窗口四");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
