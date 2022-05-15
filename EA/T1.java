import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/18 19:15
 */
class Point{
    int row;
    int column;
    public Point(int x,int y){
        this.row=x;
        this.column=y;
    }
}
public class T1 {
    static int step = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int height = input.nextInt();
        int width = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        Point start = new Point(x,y);
        int[][] grid = new int[n+1][m+1];
        int[][] visited = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                grid[i][j]=input.nextInt();
            }
        }
        //放置箱子
        for(int i=x;i<x+height;i++){
            for(int j=y;j<y+width;j++){
                grid[i][j]=0;
            }
        }
        visited[x][y]=1;
        dfs(grid,visited,height,width,start,0);
        System.out.println(step);
    }

    public static void dfs(int[][] grid,int[][] visited,int height,int width,Point leftUp,int count){
        if(count>step){
            return;
        }
        visited[leftUp.row][leftUp.column]=1;
        Point leftDown = new Point(leftUp.row+(height-1),leftUp.column);
        Point rightUp = new Point(leftUp.row, leftUp.column+(width-1));
        Point rightDown = new Point(leftUp.row+(height-1), leftUp.column+(width-1));
        if(leftUp.row==0 || leftUp.column==0 || rightUp.row==0 || rightUp.column==grid[0].length-1
                || leftDown.row==grid.length-1 || leftDown.column==0 || rightDown.row==grid.length-1 || rightDown.column==grid[0].length-1 ){
            step=Math.min(step,count);
            visited[leftUp.row][leftUp.column]=0;
            return;
        }
        if(judge(grid,"left",leftUp,leftDown)){
            Point newLocation = new Point(leftUp.row,leftUp.column-1);
//            visited[newLocation.row][newLocation.column]=1;
            if(visited[newLocation.row][newLocation.column]==0){
                dfs(grid,visited,height,width,newLocation,count+1);
            }
//            visited[newLocation.row][newLocation.column]=0;
        }
        if(judge(grid,"right",rightUp,rightDown)){
            Point newLocation = new Point(leftUp.row,leftUp.column+1);
//            visited[leftUp.row][leftUp.column]=1;
            if(visited[newLocation.row][newLocation.column]==0) {
                dfs(grid, visited, height, width, newLocation, count + 1);
            }
//            visited[leftUp.row][leftUp.column]=0;
        }
        if(judge(grid,"up",leftUp,rightUp)){
            Point newLocation = new Point(leftUp.row-1,leftUp.column);
//            visited[leftUp.row][leftUp.column]=1;
            if(visited[newLocation.row][newLocation.column]==0) {
                dfs(grid, visited, height, width, newLocation, count + 1);
            }
//            visited[leftUp.row][leftUp.column]=0;
        }
        if(judge(grid,"down",leftDown,rightDown)){
            Point newLocation = new Point(leftUp.row+1,leftUp.column);
//            visited[leftUp.row][leftUp.column]=1;
            if(visited[newLocation.row][newLocation.column]==0) {
                dfs(grid, visited, height, width, newLocation, count + 1);
            }
//            visited[leftUp.row][leftUp.column]=0;
        }
        visited[leftUp.row][leftUp.column]=0;
    }

    public static boolean judge(int[][] grid,String s,Point one,Point two){
        if("left".equals(s)){
            Point start = new Point(one.row,one.column-1);
            Point end = new Point(two.row,two.column-1);
            if(start.row<=0 || start.column<=0 || end.row>=grid.length || end.column<=0){
                return false;
            }
            for(int i=start.row;i<=end.row;i++){
                if(grid[i][start.column]==1){
                    return false;
                }
            }
        }
        else if("right".equals(s)){
            Point start = new Point(one.row,one.column+1);
            Point end = new Point(two.row,two.column+1);
            if(start.row<=0 || start.column>=grid[0].length || end.row>=grid.length || end.column>=grid[0].length){
                return false;
            }
            for(int i=start.row;i<=end.row;i++){
                if(grid[i][start.column]==1){
                    return false;
                }
            }
        }
        else if("up".equals(s)){
            Point start = new Point(one.row-1,one.column);
            Point end = new Point(two.row-1,two.column);
            if(start.row<=0 || start.column<=0 || end.row<=0 || end.column>=grid[0].length){
                return false;
            }
            for(int i=start.column;i<=end.column;i++){
                if(grid[start.row][i]==1){
                    return false;
                }
            }
        }
        else if("down".equals(s)){
            Point start = new Point(two.row+1,one.column);
            Point end = new Point(two.row+1,two.column);
            if(start.row>=grid.length || start.column<=0 || end.row>=grid.length || end.column>=grid[0].length){
                return false;
            }
            for(int i=start.column;i<=end.column;i++){
                if(grid[start.row][i]==1){
                    return false;
                }
            }
        }
        return true;
    }

}
