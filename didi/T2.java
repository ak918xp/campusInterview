import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/10/10 19:33
 */
public class T2 {
    static int max;
    public static void main(String[] args){
        max=0;
        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(input.nextLine());
        String str = input.nextLine();
        char[] nums = new char[n];
        for(int i=0;i<n;i++){
            nums[i]=str.charAt(i);
        }
        int record=0;
        int delay=0;
        for(int i=0;i<n;i++){
            if(stack.size()==0){//栈中没有元素
                stack.add(nums[i]);
            }
            else if(nums[i]=='1' && stack.peek()=='0'){
                stack.pop();
                record+=2;
                delay=0;
            }
            else if(nums[i]=='3' && stack.peek()=='2'){
                stack.pop();
                record+=2;
                delay=0;
            }
            else{
                stack.push(nums[i]);
                delay++;
                if(record>max){
                    max=record;
                }
                if(delay==2){
                    record=0;
                }
            }
        }
        if(record>max){
            max=record;
        }
        System.out.println(max);
    }
}