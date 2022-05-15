package autumn;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/22 15:18
 */
public class T1 {
    public static void main(String[] args){
        int n = 4;
        int m = 2;
        int[] weights = new int[]{4,2,3,1};
        long res = Solve(n,m,weights);
        System.out.println(res);
    }

    public static long Solve(int n, int m, int[] weights) {
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
        int big=1;
        long preK=k;
        while(!judge(n,m,k,weights)){
            preK=k;
            k+=big;
            big*=2;
        }
        long left=preK,right=k;
        long ans=-1;
        for(long i=right;i>=left;i--){
            if(!judge(n,m,i,weights)){
                ans=i+1;
                break;
            }
        }
        return ans;
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
