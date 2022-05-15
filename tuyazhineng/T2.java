/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/14 20:25
 */
public class T2 {
    public static void quickSort(int[] nums ,int left,int right){
        if(left<right){
            int i=left,j=right,x=nums[left];
            while(i<j){
                while(i<j && nums[j]>=x){
                    j--;
                }
                if(i<j){
                    nums[i++]=nums[j];
                }
                while(i<j && nums[i]<x){
                    i++;
                }
                if(i<j){
                    nums[j--]=nums[i];
                }
            }
            nums[i]=x;
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }

    public static void main(String[] args){
        int[] nums = {10,9,8,5,4,2};
        quickSort(nums,0,nums.length-1);
        for(int i=0;i< nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
