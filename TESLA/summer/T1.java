import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int res = solution(n);
        System.out.println(res);
    }

    public static int solution(int N) {
        List<Integer> num = new LinkedList<>();
        int mark=0;
        boolean isDone=false;
        if(N>0){
            while(N!=0){
                int tmp=N%10;
                num.add(tmp);
                mark++;
                N=N/10;
            }
            for(int i=mark-1;i>=0;i--){
                if(num.get(i)<5){
                    num.add(i+1,5);
                    isDone=true;
                    break;
                }
            }
            if(isDone==false){
                num.add(5);
                isDone=true;
            }
            int res=0;
            int digit=1;
            for(int i:num){
                res+=digit*i;
                digit*=10;
            }
            return res;
        }
        else if(N<0){
            N=-N;
            while(N!=0){
                int tmp=N%10;
                num.add(tmp);
                mark++;
                N=N/10;
            }
            for(int i=mark-1;i>=0;i--){
                if(num.get(i)>=5){
                    num.add(i+1,5);
                    isDone=true;
                    break;
                }
            }
            if(isDone==false){
                num.add(5);
                isDone=true;
            }
            int res=0;
            int digit=1;
            for(int i:num){
                res+=digit*i;
                digit*=10;
            }
            return -res;
        }
        return 50;
    }
}
