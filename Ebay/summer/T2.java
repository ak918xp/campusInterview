public class T2 {
    public static void main(String[] arsg){
        int[] nums = new int[]{1,2,3,4,5,6,5,4,3,2};
        int left=0,right=nums.length-1;
        System.out.println(max(nums,left,right));
    }

    public static int max(int[] nums,int left,int right){
        int mid=(left+right)/2;
        int leftVal=nums[mid-1];
        int midVal=nums[mid];
        int rightVal=nums[mid+1];
        if(midVal>leftVal && midVal>rightVal){
            return midVal;
        }
        else if(midVal<leftVal){
            return max(nums,left,mid);
        }
        else if(midVal<rightVal){
            return max(nums,mid,right);
        }
        return -1;
    }
}
