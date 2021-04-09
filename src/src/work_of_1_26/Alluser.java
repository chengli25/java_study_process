package work_of_1_26;

import work_of_1_26.coperation.IOperation;

import java.util.List;

/**
 * @author TIMI
 * @Date 2021/1/28 - 18:38
 */
abstract public class Alluser {
    public String name;
    public IOperation[] operations;

    //菜单方法
    public abstract int meau();

    public void doOperation(int choice, List booklist) throws InterruptedException {
        if(choice <= this.operations.length) {
            this.operations[choice - 1].work(booklist);
        } else {
            System.out.println("输入错误，请重新输入");
        }
    }
}
