import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/26 11:38
 */
public class T1 {
    static int max;
    static Stack<Integer> stack;
    public static void main(String[] args){
        //存储下标
        stack = new Stack<>();
        max=0;
        int[] nums = new int[]{1,2,3};
        int res = maxArea(nums);
        System.out.println(res);
    }

    public static int maxArea(int[] nums){
        int curHeight = nums[0];
        for(int i=0;i<nums.length;i++){
            while(stack.size()>0 && nums[stack.peek()]>nums[i]) {
                curHeight = nums[stack.pop()];//最小高度
                max = Math.max(max,(i-stack.peek()-1)*curHeight);
            }
            if(stack.size()>0){
                int width = stack.size();
                System.out.println(width);
                max = Math.max(max,width*curHeight);
            }
            stack.push(i);
        }
        return max;
    }
}
