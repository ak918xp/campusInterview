package spring;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/7 20:17
 */
public class GetSubArrayMaxProduct {
    public static void main(String[] args){
        long[]nums = new long[]{2,3,-2,4,-1};
        long res = GetSubArrayMaxProduct(nums);
        System.out.println(res);
    }
    public static long GetSubArrayMaxProduct(long[] nums) {
        // write code here
        int n=nums.length;
        long[] dpMax = new long[n];
        long[] dpMin = new long[n];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for(int i=1;i<n;i++){
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i]=Math.min(dpMin[i-1]*nums[i],Math.min(dpMax[i-1]*nums[i],nums[i]));
        }
        long max = Long.MIN_VALUE;
        for(int i=0;i<dpMax.length;i++){
            max=max>dpMax[i]?max:dpMax[i];
        }
        return max;
    }
}
