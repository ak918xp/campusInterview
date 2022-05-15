import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/30 19:49
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String inputParam = input.nextLine();
        String[] inputParams = inputParam.split(",");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(inputParams[i]);
        }
        List<Integer> odd= new ArrayList<>();
        List<Integer>even = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                odd.add(nums[i]);
            }
            else{
                even.add(nums[i]);
            }
        }
        int mark=0;
        for(int i=0;i<even.size();i++){
            nums[mark++]=even.get(i);
        }
        for(int i=0;i<odd.size();i++){
            nums[mark++]=odd.get(i);
        }
        print(nums);
    }

    public static void print(int[] nums){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            str.append(nums[i]);
            str.append(",");
        }
        String res =str.toString().substring(0,str.length()-1);
        System.out.println(res);
    }
}
