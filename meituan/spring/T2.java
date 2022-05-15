
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/5 10:18
 */
public class T2 {
    static int max;

    public static void main(String[] args){
        max=Integer.MIN_VALUE;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=input.nextInt();
        }
        int size= nums.length;
        while(size>=0){
            int left=0,right=left+size-1;
            while(right<nums.length){
                reverse(left,right,nums);
                left++;
                right++;
            }
            size--;
        }
        System.out.println(max);
    }

    public static void reverse(int left,int right,int[] nums){
        while(left<right){
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
            left++;
            right--;
        }
        int res = maxSubArray(nums);
        if(res>max){
            max=res;
        }
    }

    public static int maxSubArray(int[] nums){
        int max=nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[i-1]+nums[i]){
                dp[i]=nums[i];
            }
            else{
                dp[i]=dp[i-1]+nums[i];
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
