package work_of_1_26;

/**
 * @author TIMI
 * @Date 2021/1/30 - 17:41
 */
public class ClearScreen {
    //public native  static void clearScreen();
    //{
    //    System.loadLibrary("Clear");
    //}
    public static void clear() {
        for(int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }

}
