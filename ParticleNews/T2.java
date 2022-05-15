import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T2 {
    public static void main(String[] args){
        int[][] mapArray = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(findMin(mapArray));
    }

    static List<List<Integer>> path = new LinkedList<>();
    public static int findMin (int[][] mapArray) {
        // write code here
        int row= mapArray.length;
        int column=mapArray[0].length;
        List<Integer> tmpPath=new LinkedList<>();
        dfs(mapArray,row,column,tmpPath,0,0);
        int[] res = new int[path.size()];
        for(int i =0;i<res.length;i++){
            List<Integer> now = path.get(i);
            for(int j=0;j<now.size();j++){
                res[i]+=now.get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<res.length;i++){
            if(res[i]<ans){
                ans=res[i];
            }
        }
        return ans;
    }

    public static void dfs(int[][] mapArray,int row,int column,List<Integer> tmpPath,int x,int y){
        if(x>=row || y>=column){
        }
        else if(x==row-1 && y==column-1){
            tmpPath.add(mapArray[x][y]);
            List<Integer> store = new LinkedList<>(tmpPath);
            path.add(store);
            tmpPath.remove(tmpPath.size()-1);
        }
        else{
            tmpPath.add(mapArray[x][y]);
            dfs(mapArray,row,column,tmpPath,x+1,y);
            dfs(mapArray,row,column,tmpPath,x,y+1);
            tmpPath.remove(tmpPath.size()-1);

        }
    }
}
