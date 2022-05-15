/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/3/20 20:46
 */
public class T2 {
    public static void main(String[] args){
        String str = "Hello, my name is john";
        int res = count(str);
        System.out.println(res);
    }

    public int PathsCnt (int m, int n) {
        // write code here
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            res[i][0]=1;
        }
        for(int i=0;i<n;i++){
            res[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j]=res[i-1][j]+res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }

    public static int count(String str){
        String[] res = str.trim().split(" ");
        return res.length;
    }
}
