package basic_class;

/**
 * @author TIMI
 * @Date 2021/1/29 - 19:01
 */
public class TestRuntime {
    public static void main(String[] args) {
        //runtime类，表示java程序的运行时环境
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors());
        System.out.println("空闲内存数：" + rt.freeMemory());
        System.out.println("总内存数量：" + rt.totalMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());

    }
}
