import java.util.Arrays;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/16 20:10
 */
public class T3 {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int length = A.length;
        int[] array = new int[length];
        for(int i=0;i<length;i++){
            array[i]=Math.max(A[i],B[i]);
        }
        Arrays.sort(array);
        int n=1;
        for(int i=0;i<array.length;i++){
            if(array[i]==n){
                n++;
            }
        }
        return n;
    }
}
