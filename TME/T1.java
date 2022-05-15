import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/16 19:07
 */
public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        System.out.println(maxLexicographical(num));
    }
    public static String maxLexicographical (String num) {
        // write code here
        int length = num.length();
        String res = new String(num);
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                char[] ch = num.toCharArray();
                for(int k=i;k<=j;k++){
                    if(ch[k]=='1'){
                        ch[k]='0';
                    }
                    else{
                        ch[k]='1';
                    }
                }
                String tmp="";
                StringBuilder sb = new StringBuilder();
                for(int x=0;x< ch.length;x++){
                    sb.append(ch[x]);
                }
                tmp=sb.toString();
                if(tmp.compareTo(res)>0){
                    res=tmp;
                }
            }
        }
        String[] resLists = res.split(",");
        String ans = "";
        for(int i=0;i< resLists.length;i++){
            if(!resLists[i].equals(" ")){
                ans+=resLists[i].trim();
            }

        }
        return ans;
    }
}
