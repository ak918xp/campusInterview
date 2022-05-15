import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/14 15:38
 */
public class T1 {
    public static void main(String[] args){
        int[] nums =new int[]{3,6,7};
        String res = solution(nums);
        System.out.println(res);
    }

    static String maxNum;
    static List<List<Integer>> res;
    static List<Integer> tmpRes;
    static List<String> nums;
    public static String solution(int[] d) {
        res = new ArrayList<>();
        tmpRes = new ArrayList<>();
        nums = new ArrayList<>();
        maxNum = String.valueOf(Long.MIN_VALUE);
        subSet(d,0);

        for(int i=0;i<res.size();i++){
            concat(res.get(i),0,res.get(i).size()-1);
        }
        for(int i=0;i<nums.size();i++){
            String cur = nums.get(i);
            if(!"".equals(cur)){
                long num = Long.parseLong(cur);
                if(num%3==0 && num>Long.parseLong(maxNum)){
                    maxNum=cur;
                }
            }

        }
        if(maxNum.equals(String.valueOf(Long.MIN_VALUE))){
            return "";
        }
        else{
            return maxNum;
        }

    }

    public static void record(List<Integer> list){
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        nums.add(sb.toString());
    }

    public static void concat(List<Integer> list,int start,int end){
        if(start==end){
            record(list);
        }
        for(int i=start;i<=end;i++){
            int tmp=list.get(start);
            list.set(start,list.get(i));
            list.set(i,tmp);
            concat(list,start+1,end);
            tmp=list.get(start);
            list.set(start,list.get(i));
            list.set(i,tmp);
        }
    }

    public static void subSet(int[] nums,int start){
        res.add(new ArrayList<>(tmpRes));
        for(int i=start;i<nums.length;i++){
            tmpRes.add(nums[i]);
            subSet(nums,i+1);
            tmpRes.remove(tmpRes.size()-1);
        }
    }
}
