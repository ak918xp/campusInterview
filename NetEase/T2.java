import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/21 15:11
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String[] S = new String[n+1];
        S[1]="a";
        for(int i=2;i<=n;i++){
            S[i]=S[i-1]+(char)('a'+i-1)+reverse(invert(S[i-1]));
        }
        System.out.println(S[n].charAt(k-1));
    }

    public static String invert(String inputParam){
        int length=inputParam.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            char c = inputParam.charAt(i);
            int num = c-'a';
            char newChar = (char) ('z'-num);
            sb.append(newChar);
        }
        return sb.toString();
    }

    public static String reverse(String inputParam){
        int length=inputParam.length();
        StringBuilder sb = new StringBuilder();
        for(int i=length-1;i>=0;i--){
            sb.append(inputParam.charAt(i));
        }
        return sb.toString();
    }
}
