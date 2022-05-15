import java.util.Arrays;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/30 19:24
 */
public class T2 {
    public static void main(String[] args){
        int[] nums = new int[]{1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(duplicateZeros(nums)));
    }

    public static int[] duplicateZeros (int[] arr) {
        // write code here
        int[] res = new int[arr.length];
        int mark=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                res[mark++]=arr[i];
                if(mark>=arr.length){
                    break;
                }
            }
            else{
                res[mark++]=0;
                if(mark>=arr.length){
                    break;
                }
                res[mark++]=0;
                if(mark>=arr.length){
                    break;
                }
            }
        }
        return res;
    }
}
