import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/9/9 19:01
 * 目录命令
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 你需要编写一个程序来模拟目录的操作，一开始，你在根目录"\"，一共有两种命令：
 *
 * ● cd s: s为一个目录名，表示从当前工作目录的路径进入名为s的目录。特别地，"cd .."(即s=="..")表示返回上一级目录，若当前已为根目录，则无视该次操作。数据保证若s不为".."，则一定为小写字母组成的长度不超过10的字符串。
 *
 * ● pwd: 表示查看当前工作目录的路径，你需要输出这个路径。
 *
 *
 *
 * 输入描述
 * 第一个行是一个整数n，表示一共会有n个操作。
 *
 * 接下来每行是一条命令，命令的种类为问题描述中的二种之一。
 *
 * 注意，测试用例中cd s的操作，中间有空格。
 *
 * 输出描述
 * 对于每个"pwd"命令，你需要单行输出当前的工作路径。
 *
 *
 * 样例输入
 * 7
 * cd a
 * cd b
 * pwd
 * cd ..
 * pwd
 * cd ..
 * pwd
 * 样例输出
 * \a\b
 * \a
 * \
 *
 * 提示
 * 1<=n<=300
 */
public class T1 {
    static List<String> root;
    public static void main(String[] args){
        root = new ArrayList<>();
        Scanner input = new Scanner(System.in);
//        System.out.println(root);
        int n = Integer.parseInt(input.nextLine());
        String[] inputParams = new String[n];
        for(int i=0;i<n;i++){
            inputParams[i]=input.nextLine();
        }
        root.add("\\");
        doWorks(inputParams);
    }

    public static void doWorks(String[] inputParams){
        for(int i=0;i< inputParams.length;i++){
            String inputParam = inputParams[i];
            inputParam=inputParam.trim();
            if("pwd".equals(inputParam)){
                pwd(inputParam);
            }
            else{
                cd(inputParam);
            }
        }
    }

    public static void pwd(String str){
        if(root.size()==1){
            System.out.println(root.get(0));
        }
        else if(root.size()>1){
            for(int i=1;i<root.size();i++){
                System.out.print(root.get(i));
            }
            System.out.println();
        }
    }

    public static void cd(String str){
        String[] strs = str.split(" ");
        String operation = strs[0];
        String path = strs[1];
        if("..".equals(path)){
            if(root.size()>1){
                root.remove(root.size()-1);
            }
        }
        else{
            root.add("\\"+path);
        }
    }
}
