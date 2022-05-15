/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/24 11:54
 */
public class T2 {
    public static int maxPruductSubArray(int[] nums){
        int length=nums.length;
        if(length==0){
            return 0;
        }
        int[] dpMax=new int[length];
        int[] dpMin=new int[length];
        int res=nums[0];
        for(int i=1;i<length;i++){
            if(nums[i]>=0){
                dpMax[i]=Math.max(dpMax[i-1]*nums[i],nums[i]);
                dpMin[i]=Math.min(dpMin[i-1]*nums[i],nums[i]);
            }
            else{
                dpMax[i]=Math.max(nums[i],dpMin[i-1]*nums[i]);
                dpMin[i]=Math.min(nums[i],dpMax[i-1]*nums[i]);
            }
        }
        for(int i=0;i<length;i++){
            if(res<dpMax[i]){
                res=dpMax[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,0,-1,2,3,-5,-2};
        int res = maxPruductSubArray(nums);
        System.out.println(res);
    }
}
