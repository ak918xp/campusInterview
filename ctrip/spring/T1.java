import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/8 19:02
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=input.nextInt();
        }
        int[][] map = new int[n][2];
        for(int i=0;i<n;i++){
            map[i][0]=nums[i];
            map[i][1]=hole(nums[i]);
        }
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        for(int i=n-1;i>=0;i--){
            System.out.println(map[i][0]);
        }
    }

    public static int hole(int num){
        int count=0;
        while(num>0){
            int now=num%10;
            if(now==0||now==4||now==6||now==9){
                count++;
            }
            else if(now==8){
                count+=2;
            }
            num/=10;
        }
        return count;
    }

}
