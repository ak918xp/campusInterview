import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[][] container = new int[length][2];
        for(int i=0;i<length;i++){
            container[i][0]=input.nextInt();
            container[i][1]=input.nextInt();
        }
        Arrays.sort(container, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int count=0;
        for(int i =0;i<length-1;i++){
            if(container[i][1]<container[i+1][1]){
                count++;
            }
        }
        count++;
        System.out.println(count);
    }
}
