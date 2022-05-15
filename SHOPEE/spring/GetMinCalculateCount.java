package spring;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/7 19:31
 */
public class GetMinCalculateCount {
    public static void main(String[] args){
        long res = GetMinCalculateCount(10,100,22,202);
        System.out.println(res);
    }
    static long res=Long.MAX_VALUE;
    public static long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
       dfs(sourceX,sourceY,targetX,targetY,0);
       return res==Long.MAX_VALUE?-1:res;
    }

    public static void dfs(long sourceX, long sourceY, long targetX, long targetY,long count){
        if(sourceX==targetX && sourceY==targetY){
            if(res>count){
                res=count;
            }
        }
        else if(sourceX<targetX && sourceY<targetY){
            dfs(sourceX,sourceY,targetX-1,targetY-1,count+1);
            if(targetX%2==0 && targetY%2==0){
                dfs(sourceX,sourceY,targetX/2,targetY/2,count+1);
            }
        }

    }
}
