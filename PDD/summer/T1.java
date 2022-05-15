import java.util.*;

public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int i=0;i<T;i++){
            Long N = input.nextLong();
            Stack<Integer> res = new Stack<>();
            Operation(N,res);
            print(res);
            System.out.println();
        }
    }

    /**
     * 输出天数
     * @param res
     */
    private static void print(Stack<Integer> res) {
        int length=res.size();
        System.out.println(length);
        int[] ans = new int[length];
        int count=1;
        for(int i=0;i<length;i++){
            if(res.pop()==1){
                System.out.print(count+" ");
            }
            count++;
        }
    }

    /**
     * 找到共几天
     * @param n
     * @param res
     */
    private static void Operation(Long n, Stack res) {
        while(n!=0){
            //这次是否放入细胞
            Long flag=n%2;
            if(flag==1){
                res.push(1);
            }else{
                res.push(0);
            }
            n=n/2;
        }
    }
}
