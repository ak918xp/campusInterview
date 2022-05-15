import java.util.*;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/29 20:07
 */
public class T2 {
    static int max;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputParams = input.nextLine().trim();
        max = 0;
        int length = inputParams.length();
        for(int i=1;i<=length/2;i++){//长度
            for(int j=0;j<length;j++){
                if(j+i<=length){
                    String ori = inputParams.substring(j,j+i);
                    if(getSubString(i,j,ori,inputParams)){
                        max=i;
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        System.out.println(max);
    }

    public static boolean getSubString(int size,int start,String ori,String str){
        for(int i=start+ori.length();i<str.length();i++){
            if(i+size>str.length()){
                break;
            }
            String cur = str.substring(i,i+size);
            if(cur.equals(ori)){
                return true;
            }
        }
        return false;
    }

}
