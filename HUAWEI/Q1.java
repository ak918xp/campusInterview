import java.util.Scanner;
import java.util.Stack;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/8/13 19:49
 */
public class Q1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();
        String[] newPath = splitParam(path);
        String res = doWork(newPath);
        System.out.println(res);
    }

    private static String[] splitParam(String path) {
        String[] paths = path.split("/");
        return paths;
    }

    static Stack<String> stack;
    public static String doWork(String[] path){
        stack = new Stack<>();
        String res="";
        for(int i=0;i<path.length;i++){
            //..时退回上一级
            if("..".equals(path[i])){
                if(stack.size()>0){
                    stack.pop();
                }
            }
            else if(".".equals(path[i]) || "".equals(path[i]))//如果是.什么也不操作
            {
            }
            else{
                stack.push(path[i]);
            }
        }
        //输出
        if(stack.isEmpty()){
            return "/";
        }
        else{
            while(stack.size()>0){
                res="/"+stack.pop()+res;
            }
        }
        return res;
    }
}
