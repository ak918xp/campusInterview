import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer,Integer> info = new HashMap<>();
        for(int i=0;i<n;i++){
            int salary = input.nextInt();
            if(info.containsKey(salary)){
                int times = info.get(salary);
                times++;
                info.put(salary,times);
            }
            else{
                info.put(salary,1);
            }
        }
        int minSalary=100000;
        for(Map.Entry<Integer,Integer> entry: info.entrySet()){
            if(entry.getValue()==1 && entry.getKey()<minSalary){
                minSalary=entry.getKey();
            }
        }
        if(minSalary==100000){
            System.out.println(-1);
        }
        else{
            System.out.println(minSalary) ;
        }
    }
}
