import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2022/2/19 19:53
 */
public class T1 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] ch = s.toCharArray();
        int zeroCount=0;
        int num=0;
        int res=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='-'){
                zeroCount++;
            }
            else if(ch[i]>='0' && ch[i]<='9'){
                num*=10;
                num+=ch[i]-'0';
            }
            else{
                if(zeroCount%2==0){
                    res+=num;
                }
                else{
                    res-=num;
                }
                num=0;
                zeroCount=0;
            }
        }
        if(zeroCount%2==0){
            res+=num;
        }
        else{
            res-=num;
        }
        num=0;
        zeroCount=0;
        System.out.println(res);
    }
}
