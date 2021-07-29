import java.util.Scanner;

public class T3 {
    static int res;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int column = input.nextInt();
        int[][] map = new int[row][column];
        int sx=-1,sy=-1;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                map[i][j]=input.nextInt();
                if(map[i][j]==1){
                    sx=i;
                    sy=j;
                }
            }
        }
        res=0;
        int[][] visited = new int[row][column];
        findPath(map,row,column,sx,sy);
        System.out.println(res);
    }

    //寻找是否还有没走过的地方
    public static boolean search0(int[][] map){
        int row=map.length;
        int column=map[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void findPath(int[][] map,int row,int column,int x,int y){
        //路径失败的情况
        if(x<0 || x>=row || y<0 || y>=column || map[x][y]==-1 || (map[x][y]==2 && search0(map))){
            return;
        }
        //成功记录
        if(map[x][y]==2 && !search0(map)){
            res++;
        }
        //其他时候记录
        int tmpNow=map[x][y];
        map[x][y]=-1;
        findPath(map,row,column,x+1,y);
        findPath(map,row,column,x-1,y);
        findPath(map,row,column,x,y+1);
        findPath(map,row,column,x,y-1);
        map[x][y]=tmpNow;
    }
}
