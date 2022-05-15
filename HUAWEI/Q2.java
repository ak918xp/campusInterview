import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/13 21:02
 */
public class Q2 {
    static int count=0;
    static List<String> res;
    public static void main(String[] args){
        res =new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=input.nextInt();
        }
        fullArray(num,0,n-1);
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(res.get(res.size()-1));
    }

    public static String arraysToString(int[] nums){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            String tmp = Integer.toString(nums[i]);
            res.append(tmp);
        }
        return res.toString();
    }

    public static void fullArray(int[] nums,int start,int end){
        if(start==end){
            count++;
            String ans = arraysToString(nums);
            res.add(ans);
            return;
        }
        for(int i=start;i<=end;i++){
            int tmp=nums[start];
            nums[start]=nums[i];
            nums[i]=tmp;
            fullArray(nums,start+1,end);
            tmp=nums[start];
            nums[start]=nums[i];
            nums[i]=tmp;
        }
    }
}
