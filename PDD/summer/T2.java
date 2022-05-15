import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i]=input.nextInt();
        }
        //原来有多少个1
        int count=0;
        for(int i=0;i<n;i++){
            if(num[i]==1){
                count++;
            }
        }
        int add = maxWindow(num);
        System.out.println(count+add);
    }

    public static int maxWindow(int[] num){
        int max=0;
        int n=num.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(num[i]==1){
                sum--;
            }
            else if(num[i]==0){
                sum++;
            }
            if(sum>max){
                max=sum;
            }
            else if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}
