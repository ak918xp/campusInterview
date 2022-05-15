import java.util.Stack;

/**
 * @author lihaoyuan
 * @version 1.0
 * @date 2021/11/24 11:42
 */
class MaxStack{
    static Stack<Integer> stack;
    static Stack<Integer> max;

    public MaxStack(){
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int val){
        if(max.isEmpty() || val>=max.peek()){
            max.push(val);
        }
        stack.push(val);
    }

    public void pop(){
        if(max.peek().equals(stack.peek())){
            max.pop();
        }

        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMax(){
        return max.peek();
    }
}
public class T1 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        System.out.println("Hello, world!");
        MaxStack stack = new MaxStack();
        stack.push(10);
        stack.push(1);
        System.out.println(stack.getMax());//10;
        System.out.println(stack.top());//1
        stack.pop();
        stack.pop();
        stack.push(2);
        System.out.println(stack.getMax());//2
        System.out.println(stack.top());//2
        stack.push(1);
        System.out.println(stack.getMax());//2
        System.out.println(stack.top());//1
    }

    public static void test2(){
        MaxStack stack = new MaxStack();
        stack.push(10);
        stack.push(10);
        System.out.println(stack.getMax());//10
        System.out.println(stack.top());//10
        stack.pop();
        System.out.println(stack.getMax());//10
        System.out.println(stack.top());//10
    }
}
