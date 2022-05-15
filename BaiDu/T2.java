//有序数组，值为1，2，3，4，5，7，9，10，11，12，13，15，从某一点切分
//11,12,13,15,1,2,3,4,5,7,9
public class T2 {
    public static int doWork(int[] num, int target){
        int left=0,right=num.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(num[mid]<num[right]){
                right=mid;
            }
            else if(num[mid]>num[right]) {
                left=mid+1;
            }
            else{
                right--;
            }
        }
        int leftLow=0,leftHigh=left;
        int rightLow=left+1,rightHigh= num.length-1;
        if(num[leftLow]<=target && target<=num[leftHigh]){
            return find(num,leftLow,leftHigh,target);
        }
        else if(num[rightLow]<=target && target<=num[rightHigh]){
            return find(num,rightLow,rightHigh,target);
        }
        else{
            return -1;
        }
    }

    public static int find(int[] num,int left,int right,int target){
        int mid=(left+right)/2;
        if(left<=right){
            while(num[mid]<target){
                left=mid+1;
            }
            while(num[mid]>target){
                right=mid;
            }
            if(num[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}
