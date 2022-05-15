import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/5 10:03
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        int res = actions(n,nums);
        System.out.println(res);
    }

    public static int actions(int n,int[] nums){
        Arrays.sort(nums);
        int mark=n-2;
        int pre=nums[n-1];
        int count=1;
        while(mark>=0){
            if(pre-nums[mark]>1){
                pre=nums[mark];
                count++;
            }
            mark--;
        }
        return count;
    }
}
