import java.util.*;

public class T2 {
    public static void main(String[] args){
        String s =  "aaabbb";
        System.out.println(Solution(s));
    }

    public static int Solution(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        Set<Integer> set = new HashSet<>();
        int count=0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            Integer value=entry.getValue();
            while(set.contains(value) && value!=0){
                value--;
                count++;
            }
            if(!set.contains(value) && value>0){
                set.add(value);
            }
        }
        return count;
    }
}
