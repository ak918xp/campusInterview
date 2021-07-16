import java.util.Scanner;

public class SHOPEE_T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        String res = doWork(number);
        System.out.println(res);
    }

    public static String doWork(String number){
        int length=number.length();
        int mark=length-1;
        String res = "";
        int count=0;
        while(mark>=0){
            if(count==3){
                res=","+res;
                count=0;
            }
            else{
                res=number.charAt(mark--)+res;
                count++;
            }
        }
        return res;
    }
}
