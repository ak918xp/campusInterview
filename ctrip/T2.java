import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/9 19:16
 * 分段
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 有一个长度为n的序列A，序列中的第i个数为A[i] (1<=i<=n)，现在你可以将序列分成至多连续的k段。对于每一段，我们定义这一段的不平衡度为段内的最大值减去段内的最小值。显然，对于长度为1的段，其不平衡度为0。对于一种合法的分段方式（即每一段连续且不超过k段），我们定义这种分段方式的不平衡度为每一段的不平衡度的最大值。现在你需要找到不平衡度最小的分段方式，输出这种分段方式的不平衡度即可。
 *
 *
 *
 * 输入描述
 * 第一行两个空格隔开的整数n，k，分别表示序列的长度和最多可分成的段数。
 *
 * 第二行是n个用空格隔开的整数，第i个数表示A[i]的值。
 *
 * 输出描述
 * 一行一个整数，表示最小的不平衡度。
 *
 *
 * 样例输入
 * 5 3
 * 3 5 5 2 5
 * 样例输出
 * 2
 *
 * 提示
 * 数据范围：1<=n<=100000, 1<=A[i]<=100000
 *
 * 输入样例1
 *
 * 5 3
 *
 * 3 5 5 2 5
 *
 * 输出样例1
 *
 * 2
 *
 * 解释
 *
 * 最终分为[3 5 5] [2] [5]，该种分段方式的不平衡度为2。
 *
 *
 *
 * 输入样例2
 *
 * 5 4
 *
 * 3 5 5 2 5
 *
 * 输出样例2
 *
 * 0
 *
 * 解释
 *
 * 最终分为[3] [5 5] [2] [5]。
 *
 *
 *
 * 输入样例3
 *
 * 4 2
 *
 * 3 4 7 6
 *
 * 输出样例3
 *
 * 1
 *
 * 解释
 *
 * 例如对于序列[3, 4, 7, 6]，如果最多能分2段，那么分成[3, 4][7,6]的不平衡度为1，因为[3, 4]和[7, 6]的不平衡度都为1；而分成[3, 4, 7][6]的不平衡度为4，因为[3, 4, 7]的不平衡度为4，[6]的不平衡度为0，两段中不平衡度的最大值为4。
 */
public class T2 {
    static List<List<Integer>> res;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        res = new ArrayList<>();
//        dfs(0,k,nums,new ArrayList<>());
    }

    //dp[i][j]表示第i个数字为分割线，分割成j个数组后的不平衡数最小值
//    public static void doWorks(int[] nums,int count,int k){
//        int[][] dp = new int[nums.length][k+1];
//        for(int i=0;i<nums.length;i++){
//            dp[i][0]=Integer.MAX_VALUE;
//        }
//        for(int i=0;i<;i++){
//
//        }
//        for(int i=0;i<nums.length-2;i++){
//            dp[i][1]=Integer.MAX_VALUE;
//        }
//        //当只有一个数组的时候,只有以最后一个数分割才行
//        dp[nums.length-1][1]=getUnBalanceScore(nums,0,nums.length);
//    }


    public static int getUnBalanceScore(int[] nums,int start,int end){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return max-min;
    }
}
