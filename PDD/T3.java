import java.util.*;

public class T3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            int c=input.nextInt();
            int q=input.nextInt();
            boolean res = judge(a,b,c,q);
            if(res==true){
                list.add(1);
            }
            else{
                list.add(0);
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(list.get(i));
        }
    }

    public static boolean judge(int a,int b,int c,int q){
//        int[] num = new int[q+1];
        Map<Integer,Boolean> num = new LinkedHashMap<>();
        num.put(a,true);
        for(Map.Entry<Integer,Boolean> entry: num.entrySet()){
            int now=entry.getKey();
            if(entry.getValue()){
                num.put(now+b,true);
                num.put(now*c,true);
            }
        }
        if(num.containsKey(q)){
            return true;
        }
        else{
            return false;
        }
    }

//    public static boolean judge(long a,long b,long c,long q){
//        if(q/c==a || q-b==a){
//            return true;
//        }
//        else if(q>=a){
//            if(q%c==0){
//                return judge(a,b,c,q-b) || judge(a,b,c,q/c);
//            }
//            else{
//                return judge(a,b,c,q-b);
//            }
//        }
//        return false;
//    }
}
