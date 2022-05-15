import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/20 20:34
 */
public class T1 {
    static List<List<Integer>> res;
    public int[][] SubSets (int[] a) {
        // write code here
        res = new ArrayList<>();
        dfs(0,a,new ArrayList<>());
        int[][] ans = new int[res.size()][a.length];
        for(int i=0;i<res.size();i++){
            List<Integer> now = res.get(i);
            for(int j=0;j<a.length;j++){
                if(j<now.size()){
                    ans[i][j]=now.get(j);
                }
                else{
                    ans[i][j]=0;
                }
            }
        }
        return ans;
    }

    public static void dfs(int start,int[]nums ,List<Integer> list){
        if(!res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            dfs(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
