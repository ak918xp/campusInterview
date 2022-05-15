import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T1_1 {
    public static void main(String[] args){
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
        doWork(list);
    }

    public static void doWork(List<Integer> list){
        int first=-1,last=-1;
        int length= list.size();
        for(int i=1;i<length-1;i++){
            if(first<0 && list.get(i-1) > list.get(i)){
                first=i-1;
            }
            if(first>0 && list.get(i-1)>list.get(i)){
                last=i;
            }
        }
        first++;
        last++;
        System.out.println(first+" "+last);
    }
}
