package homework.important_arthtic;

import java.util.Arrays;

/**
 * @author TIMI
 * @Date 2020/12/19 - 23:25
 */
public class OddNumBeforeEven {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,10};
        int i;
        int j;
        for(i=0;i<10;i++){
            for(j=i+1;j<10;j++){
                if(arr[j]%2!=0){
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
            System.out.print(arr[i]+" ");
        }
    }
}
