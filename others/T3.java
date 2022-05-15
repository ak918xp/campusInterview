import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]= input.nextInt();
        }
        int first=Integer.MIN_VALUE;
        int mark=-1;
        for(int i=0;i<n;i++){
            if(num[i]>first){
                first=num[i];
                mark=i;
            }
        }
        num[mark]=Integer.MIN_VALUE;

        int second=Integer.MIN_VALUE;
        mark=-1;
        for(int i=0;i<n;i++){
            if(num[i]>second){
                second=num[i];
                mark=i;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }
}
