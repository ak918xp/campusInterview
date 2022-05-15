import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 15:32
 */
public class T3 {
    static List<Integer> res;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        String[] inputParams = inputParam.split(" ");
        int length=inputParams.length;
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            nums[i]=Integer.parseInt(inputParams[i]);
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        int pre=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre!=nums[i] &&i!=nums.length-1){
                tmpList.add(nums[i]);
                pre=nums[i];
            }
            else if(i==nums.length-1){
                if(nums[i]==nums[0]){
                    list.add(new ArrayList<>(tmpList));
                    tmpList=new ArrayList<>();
                    tmpList.add(nums[i]);
                }
                else{
                    if(list.size()!=0){
                        for(int j=0;j<tmpList.size();j++){
                            list.get(0).add(tmpList.get(j));
                        }
                        tmpList=new ArrayList<>();
                    }
                }
            }
            else{
                list.add(new ArrayList<>(tmpList));
                tmpList=new ArrayList<>();
                tmpList.add(nums[i]);
            }

        }
        list.add(new ArrayList<>(tmpList));
        tmpList = new ArrayList<>();
        res = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            count(list.get(i));
        }
        int ans=0;
        for(int i=0;i<res.size();i++){
            ans+=res.get(i);
        }
        System.out.println(ans);
    }

    public static void count(List<Integer> inputParams){
        int length=inputParams.size();
        int ans = (length+1)*length/2;
        res.add(ans);
    }


}
