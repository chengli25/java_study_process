package homework;

/**
 * @author TIMI
 * @Date 2020/12/16 - 15:50
 */
public class CalcuateGrade {
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 0; i < 50; i+=2) {
            sum += Twoitem(i+1);
        }
        System.out.println(sum);
    }
    public static double Twoitem(int i) {
        double sum;
        sum=1.0/i-1.0/(i+1);
        return sum;
    }
}
