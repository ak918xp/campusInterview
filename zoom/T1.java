import java.util.*;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/28 17:33
 */
public class T1 {
    public static void main(String[] args){
        int[] nums = new int[]{-1,3,2,0};
        System.out.println(find132Pattern(nums));
    }
    static Set<List<Integer>> res;
    public static int find132Pattern (int[] nums) {
        // write code here
        res = new HashSet<>();
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        fullArray(nums,0,length-1);
        for(List<Integer> list:res){
            int first=list.get(0);
            int second=list.get(1);
            int third=list.get(2);
            int indexF=map.get(first);
            int indexS=map.get(second);
            int indexT=map.get(third);
            if(indexF<indexS && indexS<indexT){
                if(first<third && third<second){
                    count++;
                }
            }
        }
        return count;
    }

    public static void fullArray(int[] nums,int start,int end){
        if(start==end){
            List<Integer> tmpRes = new ArrayList<>();
            tmpRes.add(nums[0]);
            tmpRes.add(nums[1]);
            tmpRes.add(nums[2]);
            res.add(tmpRes);
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
