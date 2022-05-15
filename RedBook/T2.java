import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 10:59
 */
public class T2 {
    static int count=0;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= Integer.parseInt(input.nextLine().trim());
        char[][] grid = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        int person=0;
        for(int i=0;i<n;i++){
            String line = input.nextLine().trim();
            char[] ch = line.toCharArray();
            grid[i]=ch;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='#'){
                    person++;
                }
            }
        }
        findPath(n,grid,0,0,person);
        System.out.println(count);
    }

    public static void findPath(int n,char[][] grid,int x,int y,int person){
        if(0<=x && x<n && 0<=y && y<n && grid[x][y]=='.'){
            grid[x][y]='#';
            if(x==n-1 && y==n-1 && person==1){
                count++;
                grid[x][y]='.';
                return;
            }
            if (person > 0) {
                findPath(n,grid,x+1,y,person-1);
                findPath(n,grid,x-1,y,person-1);
                findPath(n,grid,x,y+1,person-1);
                findPath(n,grid,x,y-1,person-1);
            }
            grid[x][y]='.';
        }
    }
}
