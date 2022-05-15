import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/28 17:49
 */
public class T2 {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int windowSize=3;
        int step=1;
        System.out.println(Arrays.toString(slideWindow(nums, windowSize, step)));
    }

    public static int[] slideWindow (int[] nums, int windowSize, int step) {
        // write code here
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int count=0;

        for(int i=0;i<n-windowSize;i+=step){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<=i+windowSize;j++){
                if(nums[j]>max){
                    max=nums[j];
                }
            }
            res.add(max);
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
