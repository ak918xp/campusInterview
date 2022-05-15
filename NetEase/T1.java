import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 15:01
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        String[] inputParams = inputParam.split(" ");
        int length=inputParams.length;
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i]=Integer.parseInt(inputParams[i]);
        }
        int m=input.nextInt();
        int count=0;
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]+nums[j]<=m){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
