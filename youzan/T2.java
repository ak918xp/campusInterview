import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/16 15:31
 */
public class T2 {
    static List<String> records;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int res = generateParenthesis(n);
        System.out.println(res);
    }

    public static int generateParenthesis (int n) {
        // write code here
        StringBuilder sb = new StringBuilder();
        records = new ArrayList<>();
        dfs(n,0,0,sb);
        return records.size();
    }

    public static void dfs(int max, int left, int right,StringBuilder sb){
        if(left>=right && left<=max){
            if(left<max){
                dfs(max,left+1,right,sb.append("("));
            }
            if(right<left){
                dfs(max,left,right+1,sb.append(")"));
            }
            if(left==max && right==max){
                if(sb.length()>0){
                    records.add(sb.toString());
                }
            }
        }
    }
}
