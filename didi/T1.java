import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/10 19:27
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine().trim());
        String[] inputParams = input.nextLine().trim().split(" ");
        double[] nums = new double[inputParams.length];
        for(int i=0;i< inputParams.length;i++){
            nums[i]=Double.parseDouble(inputParams[i]);
        }
        Set<Double> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        System.out.println(set.size());
    }
}
