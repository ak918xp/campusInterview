import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/6 19:46
 */
public class T2 {
    public static void main(String[] args){
        List<List<Integer>> inputParams = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++){
            String line = input.nextLine();
            List<Integer> inputParam = splitLine(line);
            inputParams.add(inputParam);
        }
    }

    private static List splitLine(String line) {
        List<Integer> res = new ArrayList<>();
        line=line.trim();
        int flag = line.charAt(0);
        res.add(flag);
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<line.length();i++){
            if(line.charAt(i)!=' '){
                sb.append(line.charAt(i));
            }
            else if(line.charAt(i)==' '){
                Integer num = Integer.parseInt(sb.toString());
                res.add(num);
                sb=new StringBuilder();
            }
        }
        Integer num = Integer.parseInt(sb.toString());
        res.add(num);
        return res;
    }

//    public static String judge(){
//
//    }
}
