import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //行
        int n = input.nextInt();
        //列
        int m = input.nextInt();
        //地图大小
        char[][] map = new char[n][m];

        String[] line = new String[n];
        for(int i=0;i<n;i++){
            line[i]=input.next();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char tmp = line[i].charAt(j);
                map[i][j]=tmp;
            }
        }

        int[] count = new int[4];
        for(int i=1;i<=3;i++){
            int[][] isVisit = new int[n][m];
            count[i]=dfs(map,isVisit,i);
//            System.out.println("国家"+i+"有"+count[i]+"个势力");
        }
        int res = count[1]+count[2]+count[3];
        System.out.println(res);
    }



    public static int dfs (char[][] map,int[][] isVisit,int country){
        int count=0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(isVisit[i][j]!=1){
                    if((map[i][j]-'0')==country){
                        count++;
                    }
                    dfsVisit(map,isVisit,country,i,j);
                }
            }
        }
        return count;
    }

    public static void dfsVisit(char[][] map,int[][] isVisited,int country,int i,int j){
        //越界
        if(i<0||j<0||i>map.length-1||j>map[0].length-1){
            return ;
        }
        if((map[i][j]-'0')!=country){
            return ;
        }
        if(isVisited[i][j]==1){
            return ;
        }
        else{
            isVisited[i][j]=1;
            dfsVisit(map,isVisited,country,i-1,j);
            dfsVisit(map,isVisited,country,i+1,j);
            dfsVisit(map,isVisited,country,i,j-1);
            dfsVisit(map,isVisited,country,i,j+1);
        }
    }

}
