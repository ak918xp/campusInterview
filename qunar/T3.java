import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/14 16:25
 */
public class T3 {
    static List<String> res;
    public static void main(String[] args){
        res = new ArrayList<>();
        String str="cdcdsdcdscbaabc";
        Solution(str);
    }


    public static void Solution(String str){
        int count=0;
        for(int i=0;i<=str.length()-1;i++){
            for(int j=i+1;j<=str.length();j++){
                String cur = str.substring(i,j);
                if(judge(cur)){
                    res.add(cur);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //S[i-1]=S[2n−i-1]=S[2n+i− 2-1] (1≤i≤n)
    public static boolean judge(String str){
        int length=str.length();
        int n = (length+2)/3;
        if(n<2){
            return false;
        }
        if(3*n-2!=length){
            return false;
        }
        else{
            //S[i]=S[2n−i]=S[2n+i− 2]
            for(int i=1;i<=n;i++){
                char a = str.charAt(i-1);
                char b = str.charAt(2*n-i-1);
                char c = str.charAt(2*n+i-1-2);
                if(!(a==b && b==c)){
                    return false;
                }

            }
        }
        return true;
    }

}
