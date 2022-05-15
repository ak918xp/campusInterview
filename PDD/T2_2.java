import java.util.Scanner;

public class T2_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[2*n];
        for(int i=0;i<2*n;i++){
            num[i]=input.nextInt();
        }
        int chicken=0,duck=0;
        for(int i=0;i<2*n;i++){
            if(num[i]%2==0){
                duck++;
            }
            else{
                chicken++;
            }
        }
        System.out.println(chicken+" "+duck);
    }

}
