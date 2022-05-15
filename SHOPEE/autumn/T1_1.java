package autumn;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/22 16:27
 */
public class T1_1 {
    public long Solve(int n, int m, int[] weights) {
        // write code here
        long k=0;
        long totalWeight=0;
        for (int weight : weights) {
            if (k < weight) {
                k = weight;
            }
            totalWeight+=weight;
        }
        if(k<totalWeight/m){
            k=totalWeight/m;
        }
        while(!judge(n,m,k,weights)){
            k++;
        }
        return k;
    }

    public static boolean judge(int n, int m, long k, int[] weights){
        int countWeight=0;
        int countBag=0;
        while(countBag<m && countWeight<n){
            long space=k;
            //装东西
            while(space>0 && countWeight<n && weights[countWeight]<=space){
                space-=weights[countWeight];
                countWeight++;
            }
            //换新袋子
            countBag++;
        }
        if(countWeight==n){
            return true;
        }
        return false;
    }
}
