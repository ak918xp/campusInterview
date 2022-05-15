import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/18 19:38
 */
public class T2 {
    static List<List<Integer>> res;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int c = input.nextInt();
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(input.nextInt());
        }
        int count=0;
        res = new ArrayList<>();

        dfs(0,nums,new ArrayList<>(),c);
        for(int i=0;i<res.size();i++){
            if(res.get(i).size()>0){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean equalsC(List<Integer> list,int c){
        int count=0;
        for(Integer i : list){
            count+=i;
        }
        if(c==count){
            return true;
        }
        return false;
    }

    public static void dfs(int start,List<Integer> nums,ArrayList<Integer> list,int c){
        if(!res.contains(new ArrayList<>(list)) && equalsC(list,c)){
            res.add(new ArrayList<>(list));
        }
        for(int i= start;i<nums.size();i++){
            if(nums.get(i)!=Integer.MIN_VALUE){
                list.add(nums.get(i));
                dfs(i+1,nums,list,c);
                list.remove(list.size()-1);
            }

        }
    }

}
