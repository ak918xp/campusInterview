import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/5 10:49
 */
public class T3 {
    static int x,y,z;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] nm = input.nextLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] cutXYZ = input.nextLine().trim().split(" ");
        String[] cutNum = input.nextLine().trim().split(" ");
        int[] nums = new int[cutNum.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(cutNum[i]);
        }
        x=n;
        y=n;
        z=n;
        for(int i=0;i<m;i++){
            doWorks(cutXYZ[i],nums[i]);
        }

    }

    public static void doWorks(String xyz,int nums){
        if("x".equals(xyz)){
            if(nums>=x){
                System.out.println(x*y*z);
            }
            int one=nums;
            int two=x-nums;
            System.out.println(Math.max(one,two)*y*z);
            x=one;
        }
        else if("y".equals(xyz)){
            if(nums>=y){
                System.out.println(x*y*z);
            }
            int one=nums;
            int two=y-nums;
            System.out.println(Math.max(one,two)*x*z);
            y=one;
        }
        else if("z".equals(xyz)){
            if(nums>=z){
                System.out.println(x*y*z);
            }
            int one=nums;
            int two=z-nums;
            System.out.println(Math.max(one,two)*x*y);
            z=one;
        }
    }
}
