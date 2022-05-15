import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/5 11:26
 */
public class T4 {
    static int ans;
    public static void main(String[] args){
        ans=0;
        Scanner input = new Scanner(System.in);
        String[] param_nm = input.nextLine().trim().split(" ");
        String[] param_nums = input.nextLine().trim().split(" ");
        int n=Integer.parseInt(param_nm[0]);
        int m=Integer.parseInt(param_nm[1]);
        int[] nums = new int[m];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(param_nums[i]);
        }
        String[] param_operates = new String[m];
        for(int i=0;i<m;i++){
            param_operates[i]=input.nextLine().trim();
        }
        int[] operates = new int[m];
        List<List<Integer>> operateNums = new ArrayList<>();
        for(int i=0;i<m;i++){
            String[] op = param_operates[i].split(" ");
            operates[i]=Integer.parseInt(op[0]);
            List<Integer> operateNum = new ArrayList<>();
            if(operates[i]==1){
                operateNum.add(Integer.parseInt(op[1]));
                operateNum.add(Integer.parseInt(op[2]));
                operateNums.add(operateNum);
            }
            else if(operates[i]==2){
                operateNum.add(Integer.parseInt(op[1]));
                operateNum.add(Integer.parseInt(op[2]));
                operateNum.add(Integer.parseInt(op[3]));
                operateNums.add(operateNum);
            }
        }
        doWorks(resetNums(nums,operates,operateNums),operates,operateNums);
        System.out.println(ans);
    }

    public static int resetNums(int[] nums,int[] operates,List<List<Integer>> operateNums){
        int[] mark = new int[nums.length];
        for(int i=0;i<operates.length;i++){
            if(operates[i]==1){
                List<Integer> operateNum=operateNums.get(i);
                for(int j=operateNum.get(0)-1;j<=operateNum.get(1)-1;j++){
                    mark[j]++;
                }
            }
        }
        Arrays.sort(nums);
        int flag=nums.length-1;
        int[] res = new int[nums.length];
        return 0;
    }

    public static void doWorks(int[] nums,int[] operates,List<List<Integer>> operateNums){
        for(int i=0;i< operates.length;i++){
            if(operates[i]==1){
                int res=0;
                List<Integer> operateNum = operateNums.get(i);
                for(int j=operateNum.get(0)-1;j<=operateNum.get(1)-1;j++){
                    res+=nums[j];
                }
                ans+=res;
            }
            else if(operates[i]==2){
                List<Integer> operateMum = operateNums.get(i);
                int add=operateMum.get(2);
                for(int j=operateMum.get(0)-1;j<=operateMum.get(1)-1;j++){
                    nums[j]=nums[j]+add;
                }
            }
        }
    }
}
