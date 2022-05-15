import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/18 20:07
 */
public class T3 {
    static int max;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] nm = input.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] scores = new int[m][3];
        for(int i=0;i<m;i++){
            String[] score = input.nextLine().split(" ");
            scores[i][0]=Integer.parseInt(score[0]);
            scores[i][1]=Integer.parseInt(score[1]);
            scores[i][2]=Integer.parseInt(score[2]);
        }

        max=0;
        for(int i=1;i< n+1;i++){
            int[] visited = new int[n+1];
            visited[0]=1;
            dfs(i,visited,scores,0);
        }
        System.out.println(max);
    }

    public static int allVisited(int[] visited){
        int count=0;
        for(int i=0;i<visited.length;i++){
            if(visited[i]==0){
                count++;
            }
        }
        return count;
    }

    public static void dfs(int place,int[] visited,int[][] scores,int count){
        //如果所有点都连接上了
//        System.out.println("还剩几个点:"+allVisited(visited)+" ");
        if(allVisited(visited)==0){
            //把奖励分数放入记录
            if(max<count){
                max=count;
            }
            System.out.println(" ");
            return;
        }
        //当前位置连接
//        System.out.println("当前位置:"+place+" ");
//        System.out.println("当前得分:"+count+" ");
        if(max<count){
            max=count;
        }
        visited[place]=1;
        for(int i=1;i<visited.length;i++){
            //如果对方未被访问
            if(i!=place && visited[i]==0){
                //访问对方
                dfs(i,visited,scores,count+getScore(place,i,scores));
            }
        }
        visited[place]=0;
    }

    public static int getScore(int start,int end,int[][] scores){
        for(int i=0;i<scores.length;i++){
            if(start==scores[i][0]&& end==scores[i][1]){
                return scores[i][2];
            }
            else if(start==scores[i][1]&& end==scores[i][0]){
                return scores[i][2];
            }
        }
        return 0;
    }
}
