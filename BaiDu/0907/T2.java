import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/7 19:43
 */
public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] inputParams = new String[n];
        for(int i=0;i<n;i++){
            inputParams[i]=input.nextLine();
        }
        boolean flag=false;
        for(int i=0;i<n;i++){
            String res = findPerfectNum(inputParams[i]);
            for(int j=0;j<res.length();j++){
                if(res.charAt(j)!='1' && res.charAt(j)!='2' && res.charAt(j)!='3'){
                    char now = res.charAt(j);
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                String newRes = changeNum(res);
                System.out.println(newRes);
            }
            else{
                System.out.println(res);
            }
        }
    }

    public static String changeNum(String str){
//        int num = Integer.parseInt(str);
        List<Integer> ans = new ArrayList<>();
        int flag=0;
        int mark=str.length()-1;
        while(mark>=0){
            if(str.charAt(mark)=='0'){
                ans.add(3);
                flag=1;
            }
            else if(str.charAt(mark)>'3'){
                ans.add(3);
            }
            else{
                if(flag==0){
                    ans.add(Integer.parseInt(Character.toString(str.charAt(mark))));
                }
                else{
                    flag=0;
                    int tmp=Integer.parseInt(Character.toString(str.charAt(mark)))-1;
                    if(tmp==0){
                        flag=1;
                        ans.add(3);
                    }
                    else{
                        ans.add(tmp);
                    }
                    for(int j=0;j<mark-1;j++){
                        ans.set(j,3);
                    }
                }
            }
            mark--;
        }
        StringBuilder sb = new StringBuilder();
        if(flag==1){
            for(int i=ans.size()-2;i>=0;i--){
                sb.append(ans.get(i));
            }
        }
        else{
            for(int i=ans.size()-1;i>=0;i--){
                sb.append(ans.get(i));
            }
        }
        return sb.toString();
    }

    public static String findPerfectNum(String num){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)>'3'){
                sb.append('3');
            }
            else{
                sb.append(num.charAt(i));
            }
        }
        return sb.toString();
    }
}
