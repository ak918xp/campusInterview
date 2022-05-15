import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        int count=0;
        Scanner input = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }
            else{
                int singleNum=Integer.parseInt(sb.toString());
                num.add(singleNum);
                sb = new StringBuilder();
            }
        }
        int singleNum=Integer.parseInt(sb.toString());
        num.add(singleNum);
        int length=num.size();
        for(int i=0;i<length;i++){
            if(num.get(i)%7==0){
                count++;
            }
            else{
                int now=num.get(i);
                while(now%7!=0 && now>0){
                    now=now/10;
                }
                if(now>0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
