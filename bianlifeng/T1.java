import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/1 17:17
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 便利蜂每个货架上的商品都有唯一编号(不要求连续)，当多个货架的商品出现调换的时候，会出现编号重复的情况
 *
 * 现给定一组商品编号，每次操作将会选择任意一个商品，使其编号+ 1
 *
 * 返回使这组商品编号可以放到一个货架上的最少操作次数。要求时间复杂度低于O(N方)
 *
 * 输入描述
 * 输入：3,2,1,2,1,7 输出：6 解释：经过 6 次操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 *
 * 输出描述
 * 输入：3,2,1,2,1,7 输出：6 解释：经过 6 次操作，数组将变为 [3, 4, 1, 2, 5, 7]
 *
 * 样例输入
 * 3,2,1,2,1,7
 * 样例输出
 * 6
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        inputParam=inputParam.trim();
        String[] inputParams = inputParam.split(",");
        int length=inputParams.length;
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i]=Integer.parseInt(inputParams[i]);
        }
        Set<Integer> set = new HashSet<>();
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<length;i++){
            while(set.contains(nums[i])){
                nums[i]++;
                count++;
            }
            set.add(nums[i]);
        }
        System.out.println(count);
    }
}
