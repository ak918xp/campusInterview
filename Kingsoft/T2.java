import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/24 20:04
 */
public class T2 {
//    static List<List<Integer>> threeSum;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
//        threeSum = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt();
        }
        for(int i=0;i<nums.length-3;i++){
            dfs(i,nums,new ArrayList<>());
        }

//        int max=0;
//        for(int i=0;i<threeSum.size();i++){
//            int sum=0;
//            for(int j=0;j<3;j++){
//                sum+=threeSum.get(i).get(j);
//            }
//            if (max < sum) {
//                max=sum;
//            }
//        }
        System.out.println(max);
    }

    public static void dfs(int mark,int[] nums,List<Integer> path){
        path.add(nums[mark]);
        if(path.size()==3){
//            threeSum.add(new ArrayList<>(path));
            int count=0;
            for(Integer i : path) {
                count+=i;
            }
            if(count>max) {
                max = count;
            }
            return;
        }
        for(int i=mark+1;i<nums.length;i++){
            if(path.get(path.size()-1)<nums[i]){
                dfs(i,nums,path);
                path.remove(path.size()-1);
            }
        }
    }
}