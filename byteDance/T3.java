import java.util.Scanner;

public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i =0;i<n;i++){
            System.out.println(work(input.nextInt()));
        }
    }

    public static int work(int n){
        if(n%2==0){
            return n/2;
        }
        else{
            return n/2-1;
        }
    }
}
