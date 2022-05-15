import java.util.*;

public class T1 {
    public static void main(String[] args){
//        int[] nums = new int[]{1,3,12,15,26,36,178,51,60,72,79,90,91,96,102,111,116,119,130,131,143,144,154,164,174,47,183,186,193};
//        int[] nums = new int[]{2,6,4,5,3};
        Scanner input = new Scanner(System.in);
        String inputParam = input.nextLine();
        inputParam=inputParam.trim();
        List<Integer> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<inputParam.length();i++){
            char c = inputParam.charAt(i);
            if(c!=' '){
                sb.append(c);
            }
            else{
                Integer num = Integer.parseInt(sb.toString());
                list.add(num);
                sb=new StringBuffer();
            }
        }
        Integer num = Integer.parseInt(sb.toString());
        list.add(num);
//        int[] nums =new int[list.size()];
//        for(int i=0;i<list.size();i++){
//            nums[i]=list.get(i);
//        }
        doWork(list);
    }

    public static void doWork(List<Integer> nums){
        int length=nums.size();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<length;i++){
            int first=stack.peek();
            int last=nums.get(i);
            if(first>last){
                if(i<length-1){
                    if(res.size()==0){
                        stack.pop();
                        res.add(i-1);
                        stack.push(nums.get(i));
                    }
                    else{
                        int ans1=nums.get(res.get(0));
                        if(ans1>first){
                            res.add(i);
                        }
                        else{
                            stack.pop();
                            res.add(i-1);
                            stack.push(nums.get(i));
                        }
                    }
                }
                else{
                    int ans1=nums.get(res.get(0));
                    if(ans1>first){
                        res.add(i);
                    }
                    else{
                        stack.pop();
                        res.add(i-1);
                        stack.push(nums.get(i));
                    }
                }
            }
            else{
                stack.push(nums.get(i));
            }
        }
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+1+" ");
        }
    }
}
