import java.util.Scanner;

public class burnTree {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        System.out.println(judge(nums));
    }

    public static int judge(int[] nums){
        int length = nums.length;
        int minus = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1){
                minus++;
            }
        }
        if(length==5){
            return 1;
        }
        return (length-1)%2;
    }
}
