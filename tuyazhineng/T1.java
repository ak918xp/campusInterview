/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/14 20:13
 */
public class T1 {
    public static void main(String[] args){
        String res = longestPalindrome("dabad");
        System.out.println(res);
    }
    public static String longestPalindrome (String str) {
        // write code here
        String odd = getOddStr(str);
        String even = getEvenStr(str);
        if(odd.length()>even.length()){
            return odd;
        }
        else{
            return even;
        }
    }

    //奇数
    public static String getOddStr(String str){
        String res = "";
        for(int i=0;i<str.length();i++){
            int left=i-1,right=i+1;
            String tmp ="";
            tmp+=str.charAt(i);
            while(left>=0 &&right<str.length()){
                if(str.charAt(left)==str.charAt(right)){
                    tmp=str.charAt(left)+tmp;
                    tmp=tmp+str.charAt(right);
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            if(tmp.length()>res.length()){
                res=tmp;
            }
        }
        return res;
    }

    //偶数
    public static String getEvenStr(String str){
        String res="";
        for(int i=0;i<str.length();i++){
            int left=i,right=i+1;
            String tmp="";
            while(left>=0 && right<str.length()){
                if(str.charAt(left)==str.charAt(right)){
                    tmp=str.charAt(left--)+tmp;
                    tmp=tmp+str.charAt(right++);
                }
                else{
                    break;
                }
            }
            if(tmp.length()>res.length()){
                res=tmp;
            }
        }
        return res;
    }
}
