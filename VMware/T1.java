import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/18 19:26
 */
public class T1 {
    static Set<Integer> set;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        set = new HashSet<>();
        for(int i=2;i<=n/2;i++){
            if(prime[i]){
                int k=2;
                while(k*i<=n){
                    prime[k*i]=false;
                    k++;
                }
            }
        }
        int count=0;
        for(int i=m;i< prime.length;i++){
            if(prime[i]){
                int num = i;
                while(num!=0){
                    if(num%10==1){
                        count++;
                        break;
                    }
                    num/=10;
                }
            }
        }
        System.out.println(count);
    }
}
