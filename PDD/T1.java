import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner input =new Scanner(System.in);
        int n = input.nextInt();
        int[][] num = new int[n][2];
        for(int i=0;i< num.length;i++){
            num[i][0]=input.nextInt();
            num[i][1]=input.nextInt();
        }
        boolean flag = judge(num);
        System.out.println(flag);
    }

    public static boolean judge(int[][] num){
        for(int i=0;i< num.length-1;i++){
            for(int j=i+1;j< num.length;j++){
                int lengthI=num[j][1]-num[j][0];
                int lengthJ=num[j][1]-num[j][0];
                if(lengthI>=lengthJ){
                    if(num[i][0]<=num[j][0] && num[j][1]<num[i][1]){
                        return true;
                    }
                }
                else{
                    if(num[j][0]<=num[i][0] && num[i][1]<num[j][1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
