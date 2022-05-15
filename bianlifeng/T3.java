import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/1 17:58
 */
public class T3 {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        String skuParam = input.nextLine();
        long boxCapacity = input.nextLong();
        String[] skuParams=skuParam.split(",");
        long[] skuWeight = new long[skuParams.length];
        for(int i=0;i<skuWeight.length;i++){
            skuWeight[i]=Long.parseLong(skuParams[i]);
        }
        Arrays.sort(skuWeight);
        int count=0;
        for(int i=0;i< skuWeight.length;i++){
            if(boxCapacity>= skuWeight[i]){
                boxCapacity-=skuWeight[i];
                count++;
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
}
