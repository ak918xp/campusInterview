import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/9 19:42
 * 消除连续的1
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 现在给你一个长度为n的01序列，你可以通过消除连续的1的序列来获取一定的分数。
 *
 * 题目中将给你若干个长度和分数的对应关系，你需要正确求解出对应的答案。
 *
 *
 *
 * 例如：现在给你一个长度为12的01序列111111011111。
 *
 * 现在给你如下可以获取得分的消除方式：
 *
 * 消除三个连续的1，获取得分10
 *
 * 消除四个连续的1，获取得分15
 *
 * 对于前面的六个连续的1，你的消除方案有两种：
 *
 * 消除一次连续的四个1，获得得分15，或者进行两次连续的三个1消除，获取得分20.
 *
 * 对于后面的五个连续的1，你有两种消除方案：
 *
 * 消除一次连续的四个1，获得得分15，或者消除一次连续的三个1，获得得分10
 *
 *
 *
 * 上述方案中可以获得的最大分数是20 + 15 = 35.
 *
 *
 *
 * 你的任务就是设法获得最大的消除分数。
 *
 * 请注意：不一定需要把所有的1的消除完毕，我们的目标是最大化分数而不是最大化消除个数。
 *
 *
 *
 * 输入描述
 * 第一行两个空格隔开的正整数n,m，分别表示01串的长度和消除规则的数量。
 *
 * 接下来一行字符串长度为n，每个字符只能是0或者1中的一种。
 *
 * 接下来m行，每行两个空格隔开的正整数k, x，为消除连续的k个1可以获得的分数x
 *
 * 输出描述
 * 输出可以获得的最大分数。
 *
 *
 * 样例输入
 * 11 2
 * 11111101111
 * 3 10
 * 4 15
 * 样例输出
 * 35
 *
 * 提示
 * n <= 100000, m <= 100
 *
 * 保证对于每个规则，k和x都在[1, 100]之间。
 */
public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputNM = input.nextLine();
        String[] nm = inputNM.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String inputParam = input.nextLine();
        inputParam=inputParam.trim();
        char[] nums = inputParam.toCharArray();
        int[][] rules = new int[m][2];
        for(int i=0;i<m;i++){
            String inputRule = input.nextLine();
            String[] rule = inputRule.split(" ");
            rules[i][0]= Integer.parseInt(rule[0]);
            rules[i][1]= Integer.parseInt(rule[1]);
        }
        doWorks(n,m,rules,nums);
    }

    public static void doWorks(int n,int m,int[][] rules, char[] nums){
        long[] dp = new long[n];
        for(int i=0;i<n;i++){//从数组头遍历到数组尾
            if(i-1>=0){
                dp[i]=dp[i-1];
            }
            else{
                dp[i]=0;
            }
            if(nums[i]=='0'){
                continue;
            }
            for(int j=0;j<m;j++){//从规则头遍历到规则尾
                long max=Integer.MIN_VALUE;//记录最大得分
                int preIndex=i-rules[j][0];//当前规则下连续的1
                if(preIndex>=-1){//如果倒推上一次消除结尾>0
                    boolean flag=true;
                    long tmpRes=0;
                    for(int k=preIndex+1;k<=i;k++){
                        if(nums[k]=='0'){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){//如果当前规则适用
                        if(preIndex>=0){
                            tmpRes = dp[preIndex]+rules[j][1];
                        }
                        else{
                            tmpRes = rules[j][1];
                        }
                    }
                    else{//如果当前规则不适用
                        if(preIndex>=0){
                            tmpRes = dp[preIndex];
                        }
                        else{
                            tmpRes = 0;
                        }
                    }
                    if(tmpRes>max){
                        max=tmpRes;
                    }
                }
                else{
                    if(i-1>=0){
                        max=dp[i-1];
                    }
                    else{
                        max=0;
                    }
                }
                if(dp[i]<max){
                    dp[i]=max;
                }
            }
        }
        System.out.println(dp[n-1]);
    }


}
